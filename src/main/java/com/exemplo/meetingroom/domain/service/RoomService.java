package com.exemplo.meetingroom.domain.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.meetingroom.domain.entity.Room;
import com.exemplo.meetingroom.domain.exception.ResourceNotFoundException;
import com.exemplo.meetingroom.domain.repository.RoomRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomService {

	RoomRepository roomRepository;

	public List<Room> listAll() {
		return roomRepository.findAll();
	}

	public Room findById(Long id) throws ResourceNotFoundException {
		Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

		return room;
	}

	public Room create(@Valid Room room) {
		return roomRepository.save(room);
	}

	public Room updateById(Long id, @Valid Room room) throws ResourceNotFoundException {
		verifyIfExists(id);

		return roomRepository.save(room);
	}

	public void delete(Long id) throws ResourceNotFoundException {
		verifyIfExists(id);

		roomRepository.deleteById(id);
	}

	private void verifyIfExists(Long id) throws ResourceNotFoundException {
		roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

}
