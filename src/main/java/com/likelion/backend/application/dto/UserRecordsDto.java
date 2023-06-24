package com.likelion.backend.application.dto;

import com.likelion.backend.domain.entity.ReserveRecord;
import com.likelion.backend.domain.entity.User;
import com.likelion.backend.presentation.request.ChangeRoomInfoRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRecordsDto {
    private Long id;
    private String name;
    private boolean gender;
    private String contact;
    private List<ReserveRecord> recordList = new ArrayList<>();

    public static UserRecordsDto from(User user) {
        return UserRecordsDto.builder()
                .id(user.getId())
                .name(user.getName())
                .gender(user.isGender())
                .contact(user.getContact())
                .recordList(user.getReservedUserList())
                .build();
    }

}
