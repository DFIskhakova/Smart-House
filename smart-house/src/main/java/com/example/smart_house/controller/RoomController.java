package com.example.smart_house.controller;

import com.example.smart_house.model.Room;
import com.example.smart_house.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable Long id) {
        Room room = roomService.getRoomById(id);
        return room != null ? ResponseEntity.ok(room) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody @Valid Room room) {
        Room newRoom = roomService.createRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRoom);
    }

    @PutMapping("/{id}/temperature")
    public ResponseEntity<Room> updateRoomTemperature(@PathVariable Long id, @RequestParam Double temperature) {
        Room updated = roomService.updateRoomTemperature(id, temperature);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        if (roomService.deleteRoom(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}