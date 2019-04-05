package it.trolle.traffic.model.external.stoppoint;

import com.fasterxml.jackson.annotation.*;


@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPointResponse {
    @JsonProperty("StatusCode")
    private int statusCode = -1;

    @JsonProperty("ResponseData")
    private StopPointResponseData responseData;

    public int getStatusCode() {
        return statusCode;
    }

    public StopPointResponseData getResponseData() {
        return responseData;
    }

    @Override
    public String toString() {
        return "StopPointResponse{" +
                "statusCode=" + statusCode +
                ", responseData=" + responseData +
                '}';
    }
}
