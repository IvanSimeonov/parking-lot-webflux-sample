package com.ivssim.notification.mappers;

import com.ivssim.clients.notification.NotificationDTO;
import com.ivssim.notification.models.Notification;
import org.mapstruct.Mapper;

@Mapper
public interface NotificationMapper {

    Notification toEntity(NotificationDTO notificationDTO);

    NotificationDTO toDTO(Notification notification);
}
