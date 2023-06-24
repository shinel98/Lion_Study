package com.likelion.backend.presentation.response;

import com.likelion.backend.application.dto.RoomDto;
import com.likelion.backend.domain.entity.Room;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomInfoResponse {

    private Long id;
    private String name;
    private Integer capacity;
    private String description;
    public static RoomInfoResponse from (RoomDto roomDto){
        return RoomInfoResponse.builder()
                .id(roomDto.getId())
                .name(roomDto.getName())
                .capacity(roomDto.getCapacity())
                .description(roomDto.getDescription())
                .build();
    }

    public static RoomInfoResponse from (Room room){
        return RoomInfoResponse.builder()
                .id(room.getId())
                .name(room.getName())
                .capacity(room.getCapacity())
                .description(room.getDescription())
                .build();
    }
}
