package com.exemplo.meetingroom.api.v1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

	private Long id;

	@NotBlank
	@Size(min = 2, max = 50)
	private String name;

	@NotBlank
	private String date;

	@NotBlank
	private String startHour;

	@NotBlank
	private String endHour;
}
