package com.likelion.backend.application.dto;

import com.likelion.backend.domain.entity.Room;
import com.likelion.backend.presentation.request.AddRoomRequest;
import com.likelion.backend.presentation.request.ChangeRoomInfoRequest;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto {
    private Long id;

    private String name;

    private Integer capacity;

    private String description;


    public static RoomDto from(ChangeRoomInfoRequest request) {
        return RoomDto.builder()
                .id(request.getId())
                .name(request.getName())
                .capacity(request.getCapacity())
                .description(request.getDescription())
                .build();
    }

    public static RoomDto from(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .name(room.getName())
                .capacity(room.getCapacity())
                .description(room.getDescription())
                .build();
    }


    public static RoomDto toAdd(AddRoomRequest request) {
        return RoomDto.builder()
                .name(request.getName())
                .capacity(request.getCapacity())
                .description(request.getDescription())
                .build();
    }
}
