package com.example.smart_house.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 100, message = "Название устройства должно содержать от 2 до 100 символов")
    @Column(nullable = false, length = 100)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceType type;

    @Min(0)
    @Column(nullable = false)
    private Double power;

    @Column(nullable = false)
    private boolean isActive = false;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String location;

    @Column(nullable = false)
    private Integer roomId;
}

enum DeviceType {
    LIGHT, COFFEE_MACHINE, SPEAKERS, KETTLE, MICROWAVE, THERMOSTAT, CURTAINS
}