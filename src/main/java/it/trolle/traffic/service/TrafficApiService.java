package it.trolle.traffic.service;

import it.trolle.traffic.model.*;
import it.trolle.traffic.model.external.journey.*;
import it.trolle.traffic.model.external.stoppoint.*;
import org.springframework.web.client.*;
import java.util.*;
import java.util.stream.*;

public class TrafficApiService {
    private static final String JOURNEY_API_URL = "https://api.sl.se/api2/linedata.json?key=f3f33e502a7843c6869af2292fec2648&model=jour&DefaultTransportModeCode=BUS";
    private static final String STOP_POINT_API_URL = "https://api.sl.se/api2/linedata.json?key=f3f33e502a7843c6869af2292fec2648&model=stop&DefaultTransportModeCode=BUS";

    private RestTemplate restTemplate;

    //Would be Autowired in real setting
    public TrafficApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Collection<BusLine> getBuslinesWithStopsFromApi() {
        Map<String, BusLine> busLines = new HashMap<>();

        Map<Long, BusStop> busStops = getBusStops();
        JourneyResponse journeys = getBusJourneys();

        for (JourneyPatternPoint journeyPatternPoint : journeys.getResponseData().getResult()) {
            String lineNumber = journeyPatternPoint.getLineNumber();
            busLines.putIfAbsent(lineNumber, new BusLine(lineNumber));

            BusStop currentBusStop = busStops.get(journeyPatternPoint.getJourneyPatternPointNumber());
            busLines.get(lineNumber)
                    .getBusStops()
                    .add(currentBusStop);

        }

        return busLines.values();
    }

    private Map<Long, BusStop> getBusStops() {
        StopPointResponse stopPointResponse = getBusStopPoints();
        return buildBusStopMap(stopPointResponse.getResponseData().getResult());
    }

    private JourneyResponse getBusJourneys() {
        //Todo error handling
        return restTemplate.getForObject(JOURNEY_API_URL, JourneyResponse.class);
    }


    private StopPointResponse getBusStopPoints() {
        //Todo error handling
        return restTemplate.getForObject(STOP_POINT_API_URL, StopPointResponse.class);
    }

    private Map<Long, BusStop> buildBusStopMap(List<StopPoint> stopPointList) {
        return stopPointList.stream()
                .collect(
                        Collectors.toMap(
                                StopPoint::getStopPointNumber,
                                stopPoint -> new BusStop(stopPoint.getStopAreaNumber(), stopPoint.getStopPointName())
                        ));

    }
}
