package com.likelion.backend.domain.repository;

import com.likelion.backend.domain.entity.ReserveRecord;
import com.likelion.backend.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReserveRepository extends JpaRepository<Room, Long> {
    @Query("select r from ReserveRecord r  where r.user.id = :userId")
    List<ReserveRecord> findAllByUserId(Long userId);
}
