package com.likelion.backend.domain.repository;

import com.likelion.backend.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
