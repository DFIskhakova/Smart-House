package com.example.smart_house.repository;

import com.example.smart_house.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findByTitleStartingWithIgnoreCase(String title);
    List<Device> findByLocation(String location);
    List<Device> findByIsActive(boolean isActive);
    List<Device> findByRoomId(Integer roomId);
}