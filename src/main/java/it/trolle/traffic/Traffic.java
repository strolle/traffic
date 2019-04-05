package it.trolle.traffic;

import it.trolle.traffic.model.*;
import it.trolle.traffic.service.*;
import org.springframework.web.client.*;

import java.util.*;

public class Traffic {
    private static final int BUS_STOPS_TO_PRINT = 10;
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        List<BusLine> busLineList = new ArrayList(new TrafficApiService(restTemplate).getBuslinesWithStopsFromApi());
        busLineList.sort(Comparator.comparingInt(line -> -line.getBusStops().size()));

        System.out.println("Bus lines with most stops:");
        busLineList.stream()
                .limit(BUS_STOPS_TO_PRINT)
                .map(BusLine::getName)
                .forEachOrdered(System.out::println);

        BusLine topBusLine = busLineList.get(0);
        System.out.println("\nStops for bus line " + topBusLine.getName() + " (" + topBusLine.getBusStops().size() + " stops)");

        topBusLine.getBusStops().stream()
                .map(BusStop::getName)
                .forEachOrdered(System.out::println);

        System.exit(0);
    }
}
