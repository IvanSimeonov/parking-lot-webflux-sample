package com.ivssim.clients.notification;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {

    private Long id;

    private String message;

    private Timestamp sendDate;

    private String vehicleLicensePlate;

    private Long vehicleId;
}
