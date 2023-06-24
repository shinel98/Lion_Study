package com.likelion.backend.presentation.controller;

import com.likelion.backend.application.dto.UserRecordsDto;
import com.likelion.backend.application.service.ReserveService;
import com.likelion.backend.application.service.RoomService;
import com.likelion.backend.domain.entity.ReserveRecord;
import com.likelion.backend.presentation.response.UserRecordsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReserveRecordController {

    @Autowired
    private final ReserveService reserveService;
    @GetMapping("/reserveRecord/{userId}")
    public ResponseEntity<UserRecordsResponse> getUserRecords(@PathVariable Long userId) {
        UserRecordsDto userDto  = reserveService.readReservation(userId);
        UserRecordsResponse response = UserRecordsResponse.from(userDto);
        System.out.println("response = " + response);
        return ResponseEntity.ok(response);
    }
}
