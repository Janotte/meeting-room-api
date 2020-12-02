package com.exemplo.meetingroom.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.meetingroom.domain.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
