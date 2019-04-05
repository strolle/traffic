package it.trolle.traffic.model.external.stoppoint;

import com.fasterxml.jackson.annotation.*;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPointResponseData {
    @JsonProperty("Result")
    private List<StopPoint> result;

    public List<StopPoint> getResult() {
        return result;
    }

    public void setResult(List<StopPoint> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "StopPointResponseData{" +
                "result=" + result +
                '}';
    }
}
