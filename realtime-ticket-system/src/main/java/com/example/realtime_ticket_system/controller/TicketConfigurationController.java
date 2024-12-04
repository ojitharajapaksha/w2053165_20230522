package com.example.realtime_ticket_system.controller;

import com.example.realtime_ticket_system.model.TicketConfiguration;
import com.example.realtime_ticket_system.service.TicketConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/configurations")
public class TicketConfigurationController {

    @Autowired
    private TicketConfigurationService service;

    @PostMapping
    public TicketConfiguration save(@RequestBody TicketConfiguration config) {
        return service.saveConfiguration(config);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketConfiguration> get(@PathVariable Long id) {
        return service.getConfiguration(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}