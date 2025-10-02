package com.example.smart_house.service;

import com.example.smart_house.model.Room;
import com.example.smart_house.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final DeviceService deviceService;

    public RoomService(RoomRepository roomRepository, DeviceService deviceService) {
        this.roomRepository = roomRepository;
        this.deviceService = deviceService;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoomTemperature(Long id, Double temperature) {
        return roomRepository.findById(id).map(room -> {
            room.setTemperature(temperature);
            return roomRepository.save(room);
        }).orElse(null);
    }

    public boolean deleteRoom(Long id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        }
        return false;
    }
}