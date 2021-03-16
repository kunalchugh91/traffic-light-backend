package com.example.trafficlight;

import org.springframework.stereotype.Service;

@Service
public class TLService {

    public TLService() {
    }

    public TLStatusResponse getNextStatus(TLStatusRequest currentStatus) {
        TLState nextState = null;
        int nextLight = 0;

        if (currentStatus.currentLight == currentStatus.numberOfLights - 1 && currentStatus.state == TLState.STOP
                && currentStatus.walkBtnPushed == true) {
            nextState = TLState.WALK;
            nextLight = -1;
        } else {

            if (currentStatus.state == TLState.GO) {
                nextState = TLState.PREPARE_TO_STOP;
                nextLight = currentStatus.currentLight;
            }
            if (currentStatus.state == TLState.PREPARE_TO_STOP) {
                nextState = TLState.STOP;
                nextLight = currentStatus.currentLight;
            }
            if (currentStatus.state == TLState.STOP) {
                nextState = TLState.GO;
                nextLight = (currentStatus.currentLight == currentStatus.numberOfLights - 1 ? 0
                        : currentStatus.currentLight + 1);
            }
            if (currentStatus.state == TLState.WALK) {
                nextState = TLState.GO;
                nextLight = 0;
            }

        }

        return new TLStatusResponse(nextState, nextLight);
    }

}
