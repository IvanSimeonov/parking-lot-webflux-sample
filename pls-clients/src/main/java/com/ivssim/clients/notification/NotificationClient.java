package com.ivssim.clients.notification;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "notification", url = "http://pls-notification-service")
public interface NotificationClient {

    @PostMapping("/notifications")
    Mono<NotificationDTO> addNewNotification(@RequestBody NotificationDTO notificationDTO);

    }
