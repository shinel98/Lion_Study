package com.likelion.backend.application.service;

import com.likelion.backend.application.dto.RoomDto;
import com.likelion.backend.application.dto.UserRecordsDto;
import com.likelion.backend.domain.entity.ReserveRecord;
import com.likelion.backend.domain.entity.Room;
import com.likelion.backend.domain.entity.User;
import com.likelion.backend.domain.repository.ReserveRepository;
import com.likelion.backend.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReserveService {

    private final ReserveRepository reserveRepository;
    private final UserRepository userRepository;

    @Transactional
    public UserRecordsDto readReservation(Long userId){
//        List<ReserveRecord> recordList = reserveRepository.findAllByUserId(userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("no such user"));
        UserRecordsDto userDto = UserRecordsDto.from(user);

        return userDto;
    }
}
