package com.ivssim.notification.services;

import com.ivssim.clients.notification.NotificationDTO;
import com.ivssim.notification.mappers.NotificationMapper;
import com.ivssim.notification.models.Notification;
import com.ivssim.notification.repositories.NotificationRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
        notificationMapper = Mappers.getMapper(NotificationMapper.class);
    }

    @Override
    public Flux<NotificationDTO> findAllNotifications() {
        return Flux.fromIterable(this.notificationRepository.findAll().stream().map(notificationMapper::toDTO).collect(Collectors.toList()));
    }

    @Override
    public void addNewNotification(NotificationDTO notificationDTO) {
        Notification notificationToSave = this.notificationMapper.toEntity(notificationDTO);
        this.notificationRepository.save(notificationToSave);
    }
}
