package com.likelion.backend.application.service;

import com.likelion.backend.application.dto.RoomDto;
import com.likelion.backend.domain.entity.Room;
import com.likelion.backend.domain.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;


    @Transactional
    public Long addRoom(RoomDto dto){
        Room newRoom = roomRepository.save(Room.toRoom(dto));
        return newRoom.getId();
    }
    @Transactional
    public Long changeRoomInfo(RoomDto dto){
        Room room = roomRepository.findById(dto.getId()).orElseThrow(() -> new IllegalArgumentException("no such room"));
        room.setName("수정 후 이름");
        room.setCapacity(30);
        room.setDescription("정보를 수정한 방이다.");

        Room updatedRoom = roomRepository.save(room);
        return updatedRoom.getId();
    }

    @Transactional
    public Room getOneRoom(Long roomId){

        Room room = roomRepository.findById(roomId).orElseThrow(() -> new IllegalArgumentException("no such room"));
        return room;
    }
    @Transactional
    public List<RoomDto> getAllRoomList(){
        List<Room> roomList = roomRepository.findAll();
        return roomList.stream().map(RoomDto::from).collect(Collectors.toList());
    }

    @Transactional
    public void deleteRoom(Long roomId){
        System.out.println("roomId = " + roomId);
        roomRepository.deleteById(roomId);
    }
}
