package com.ivssim.notification.services;

import com.ivssim.clients.notification.NotificationDTO;
import reactor.core.publisher.Flux;

public interface NotificationService {

    void addNewNotification(NotificationDTO notificationDTO);
    Flux<NotificationDTO> findAllNotifications();
}
