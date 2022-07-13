package com.ivssim.notification.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @CreationTimestamp
    @Column(name = "send_date", updatable = false)
    private Timestamp sendDate;

    @Column(name = "send_to_vehicle_license_plate", nullable = false)
    private String vehicleLicensePlate;

    @Column(name = "send_to_vehicle_id", nullable = false)
    private Long vehicleId;


}
