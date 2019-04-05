package it.trolle.traffic.model.external.journey;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JourneyPatternPoint {
    @JsonProperty("LineNumber")
    private String lineNumber;

    @JsonProperty("JourneyPatternPointNumber")
    private long journeyPatternPointNumber;

    public String getLineNumber() {
        return lineNumber;
    }

    public long getJourneyPatternPointNumber() {
        return journeyPatternPointNumber;
    }

    @Override
    public String toString() {
        return "JourneyPatternPoint{" +
                "lineNumber='" + lineNumber + '\'' +
                ", journeyPatternPointNumber=" + journeyPatternPointNumber +
                '}';
    }
}
