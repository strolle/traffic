package it.trolle.traffic.model.external.journey;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JourneyResponse {
    @JsonProperty("StatusCode")
    private int statusCode = -1;

    @JsonProperty("ResponseData")
    private JourneyResponseData responseData;

    public int getStatusCode() {
        return statusCode;
    }

    public JourneyResponseData getResponseData() {
        return responseData;
    }

    @Override
    public String toString() {
        return "JourneyResponse{" +
                "statusCode=" + statusCode +
                ", responseData=" + responseData +
                '}';
    }
}
