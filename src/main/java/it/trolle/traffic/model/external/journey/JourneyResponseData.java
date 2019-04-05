package it.trolle.traffic.model.external.journey;

import com.fasterxml.jackson.annotation.*;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JourneyResponseData {
    @JsonProperty("Result")
    private List<JourneyPatternPoint> result;

    public List<JourneyPatternPoint> getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "JourneyResponseData{" +
                "result=" + result +
                '}';
    }
}
