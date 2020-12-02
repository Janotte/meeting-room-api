package com.exemplo.meetingroom.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.meetingroom.domain.entity.Room;
import com.exemplo.meetingroom.domain.exception.ResourceNotFoundException;
import com.exemplo.meetingroom.domain.service.RoomService;

import lombok.AllArgsConstructor;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/rooms")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomController {

	private RoomService roomService;

	@GetMapping
	public List<Room> getAllRooms() {
		return roomService.listAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Room findRoomById(@PathVariable Long id) throws ResourceNotFoundException {
		return roomService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Room createRoom(@RequestBody @Valid Room room) {
		return roomService.create(room);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Room updateRoomById(@PathVariable Long id, @RequestBody @Valid Room room) throws ResourceNotFoundException {
		return roomService.updateById(id, room);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRoomById(@PathVariable Long id) throws ResourceNotFoundException {
		roomService.delete(id);
	}

}
