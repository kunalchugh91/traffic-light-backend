package com.example.trafficlight;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/traffic")
public class TrafficController {

    @Autowired
    private TLService tlService;

    @PostMapping("/status")
    public ResponseEntity<TLStatusResponse> getLightStatus(@RequestBody TLStatusRequest currentStatus) {
        TLStatusResponse foundTLStatus = tlService.getNextStatus(currentStatus);
        return ResponseEntity.ok(foundTLStatus);
    }

}
