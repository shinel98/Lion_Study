package com.likelion.backend.presentation.response;

import com.likelion.backend.application.dto.RoomDto;
import com.likelion.backend.application.dto.UserRecordsDto;
import com.likelion.backend.domain.entity.ReserveRecord;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserRecordsResponse {
    private Long id;
    private String name;
    private boolean gender;
    private String contact;
    private List<ReserveRecord> recordList = new ArrayList<>();

    public static UserRecordsResponse from (UserRecordsDto userDto){
        return UserRecordsResponse.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .gender(userDto.isGender())
                .contact(userDto.getContact())
                .recordList(userDto.getRecordList())
                .build();
    }
}
