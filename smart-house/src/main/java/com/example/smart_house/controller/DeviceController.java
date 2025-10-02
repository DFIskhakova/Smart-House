package com.example.smart_house.controller;

import com.example.smart_house.model.Device;
import com.example.smart_house.service.DeviceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDevice(@PathVariable Long id) {
        Device device = deviceService.getDeviceById(id);
        return device != null ? ResponseEntity.ok(device) : ResponseEntity.notFound().build();
    }

    @GetMapping("/location/{location}")
    public List<Device> getDevicesByLocation(@PathVariable String location) {
        return deviceService.getDevicesByLocation(location);
    }

    @GetMapping("/active")
    public List<Device> getActiveDevices() {
        return deviceService.getActiveDevices();
    }

    @GetMapping("/power/total")
    public ResponseEntity<Double> getTotalPowerConsumption() {
        return ResponseEntity.ok(deviceService.getTotalPowerConsumption());
    }

    @PostMapping
    public ResponseEntity<Device> addDevice(@RequestBody @Valid Device device) {
        Device newDevice = deviceService.createDevice(device);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDevice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody @Valid Device device) {
        Device updated = deviceService.updateDevice(id, device);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Device> toggleDevice(@PathVariable Long id) {
        Device toggled = deviceService.toggleDevice(id);
        return toggled != null ? ResponseEntity.ok(toggled) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        if (deviceService.deleteDevice(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}