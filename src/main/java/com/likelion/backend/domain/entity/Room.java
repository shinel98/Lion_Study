package com.likelion.backend.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.likelion.backend.application.dto.RoomDto;
import com.likelion.backend.domain.entity.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE room SET deleted = true WHERE id = ?")
public class Room extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer capacity;

    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<ReserveRecord> reservedRoomList = new ArrayList<>();

    public static Room toRoom(RoomDto dto) {
        return Room.builder()
                .name(dto.getName())
                .capacity(dto.getCapacity())
                .description(dto.getDescription())
                .build();
    }

}
