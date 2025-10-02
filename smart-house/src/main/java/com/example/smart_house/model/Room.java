package com.example.smart_house.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModeType currentMode = ModeType.NORMAL;

    @Column(nullable = false)
    private Double temperature = 22.0;

    @Column(nullable = false)
    private Boolean lightsOn = false;
}

enum ModeType {
    MORNING, DAY, EVENING, NIGHT, VACATION, NORMAL
}