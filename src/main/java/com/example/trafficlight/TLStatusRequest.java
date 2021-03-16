package com.example.trafficlight;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TLStatusRequest {
    public TLState state;
    public int numberOfLights;
    public int currentLight;
    public boolean walkBtnPushed;

    @JsonCreator
    TLStatusRequest(@JsonProperty("state") TLState state,
                    @JsonProperty("numberOfLights") int numberOfLights,
                    @JsonProperty("currentLight") int currentLight,
                    @JsonProperty("walkBtnPushed") boolean walkBtnPushed) {
        this.state = state;
        this.walkBtnPushed = walkBtnPushed;
        this.numberOfLights = numberOfLights;
        this.currentLight = currentLight;
    }
}
