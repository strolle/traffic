package it.trolle.traffic.model.external.stoppoint;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPoint {
    @JsonProperty("StopPointNumber")
    private long stopPointNumber;

    @JsonProperty("StopPointName")
    private String stopPointName;

    @JsonProperty("StopAreaNumber")
    private long stopAreaNumber;

    public long getStopPointNumber() {
        return stopPointNumber;
    }

    public String getStopPointName() {
        return stopPointName;
    }

    public long getStopAreaNumber() {
        return stopAreaNumber;
    }

    @Override
    public String toString() {
        return "StopPoint{" +
                "stopPointNumber=" + stopPointNumber +
                ", stopPointName='" + stopPointName + '\'' +
                ", stopAreaNumber=" + stopAreaNumber +
                '}';
    }
}
