package com.vorobev.generalservice.controllers;

import com.vorobev.generalservice.entities.Order;
import com.vorobev.generalservice.services.interfaces.IDynanamoDbQueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/generalservice")
public class DbAsyncIntegrationController {

    private final IDynanamoDbQueueService dynanamoDbQueueService;

    @PostMapping("/addOrder")
    public ResponseEntity<Object> send(@RequestBody Order order) {
        dynanamoDbQueueService.addorder(order);
        return ResponseEntity.ok().build();
    }
}
