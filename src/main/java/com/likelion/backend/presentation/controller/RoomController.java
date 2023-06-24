package com.likelion.backend.presentation.controller;

import com.likelion.backend.application.dto.RoomDto;
import com.likelion.backend.application.service.RoomService;
import com.likelion.backend.domain.entity.Room;
import com.likelion.backend.presentation.request.AddRoomRequest;
import com.likelion.backend.presentation.request.ChangeRoomInfoRequest;
import com.likelion.backend.presentation.response.RoomInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoomController {
    @Autowired
    private final RoomService roomService;

    @PostMapping("/room")
    public ResponseEntity<Long> save(@RequestBody AddRoomRequest request) {
        Long savedId = roomService.addRoom(RoomDto.toAdd(request));
        return ResponseEntity.ok(savedId);
    }

    @GetMapping("/room")
    public ResponseEntity<RoomInfoResponse> getOneRoom(@PathVariable Long roomId) {
        Room room = roomService.getOneRoom(roomId);
        return ResponseEntity.ok(RoomInfoResponse.from(room));
    }

    @GetMapping("/room-list")
    public ResponseEntity<List<RoomInfoResponse>> getAllRoomList() {
        List<RoomDto> roomDtoList = roomService.getAllRoomList();
        List<RoomInfoResponse> response = roomDtoList.stream()
                .map(RoomInfoResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/room")
    public ResponseEntity<Void> deleteById(@RequestParam Long roomId) {
        roomService.deleteRoom(roomId);
        return ResponseEntity.ok(null);
    }

    @PatchMapping("/room")
    public ResponseEntity<Void> changeMRegularStatus (@RequestBody ChangeRoomInfoRequest request) {
        Long updatedId = roomService.changeRoomInfo(RoomDto.from(request));
        return ResponseEntity.ok(null);
    }
}
