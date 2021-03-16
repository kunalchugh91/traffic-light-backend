package com.example.trafficlight;

public enum TLState {
    GO("GO"), PREPARE_TO_STOP("PREPARE_TO_STOP"), STOP("STOP"), WALK("WALK");

    public final String value;

    private TLState(String value) {
        this.value = value;
    }
}
