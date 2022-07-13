package com.ivssim.notification.controllers;

import com.ivssim.clients.notification.NotificationDTO;
import com.ivssim.notification.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notifications")
    public Flux<NotificationDTO> getAllNotifications() {
        return this.notificationService.findAllNotifications();
    }

    @PostMapping("/notifications")
    public Mono<NotificationDTO> addNewNotification(@RequestBody NotificationDTO notificationDTO) {
        this.notificationService.addNewNotification(notificationDTO);
        return Mono.empty();
    }
}
