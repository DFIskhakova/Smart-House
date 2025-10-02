package com.example.smart_house.service;

import com.example.smart_house.model.Device;
import com.example.smart_house.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public List<Device> getDevicesByLocation(String location) {
        return deviceRepository.findByLocation(location);
    }

    public List<Device> getActiveDevices() {
        return deviceRepository.findByIsActive(true);
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device updateDevice(Long id, Device device) {
        return deviceRepository.findById(id).map(existingDevice -> {
            existingDevice.setTitle(device.getTitle());
            existingDevice.setType(device.getType());
            existingDevice.setPower(device.getPower());
            existingDevice.setActive(device.isActive());
            existingDevice.setLocation(device.getLocation());
            existingDevice.setRoomId(device.getRoomId());
            return deviceRepository.save(existingDevice);
        }).orElse(null);
    }

    public Device toggleDevice(Long id) {
        return deviceRepository.findById(id).map(device -> {
            device.setActive(!device.isActive());
            return deviceRepository.save(device);
        }).orElse(null);
    }

    public boolean deleteDevice(Long id) {
        if (deviceRepository.existsById(id)) {
            deviceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Double getTotalPowerConsumption() {
        return deviceRepository.findByIsActive(true)
                .stream()
                .mapToDouble(Device::getPower)
                .sum();
    }
}