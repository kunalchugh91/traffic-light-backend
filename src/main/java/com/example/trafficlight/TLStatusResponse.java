package com.example.trafficlight;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TLStatusResponse {

    public TLState state;
    public int currentLight;

    @JsonCreator
    TLStatusResponse(@JsonProperty("state") TLState state, @JsonProperty("currentLight") int currentLight) {
        this.state = state;
        this.currentLight = currentLight;
    }

}
