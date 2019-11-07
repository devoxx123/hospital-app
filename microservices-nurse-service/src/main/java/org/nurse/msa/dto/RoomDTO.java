package org.nurse.msa.dto;

public class RoomDTO {
	private Long id;
	private String roomNumber;
	private String roomType;
	private String roomCharges;
	private String roomStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomCharges() {
		return roomCharges;
	}

	public void setRoomCharges(String roomCharges) {
		this.roomCharges = roomCharges;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

}

/* INSERT INTO `room` VALUES (1,'General',5000,'Vacant') */
