package com.likelion.backend.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddRoomRequest {

    private String name;

    private Integer capacity;

    private String description;
}
