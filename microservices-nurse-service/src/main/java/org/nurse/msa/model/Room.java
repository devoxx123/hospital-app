package org.nurse.msa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM_TBL")
public class Room implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String roomNumber;
	private String roomStatus;
	private int numberOfBeds;
	private int numberOfAvailableBeds;
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = false, targetEntity = RoomType.class, cascade = javax.persistence.CascadeType.REMOVE)
	@JoinColumn(name = "roomType_id", referencedColumnName = "roomTypeId")
	private RoomType roomType;

	public Room() {
	}

	public Room(Long id, String roomNumber, String roomStatus, int numberOfBeds, int numberOfAvailableBeds) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.roomStatus = roomStatus;
		this.numberOfBeds = numberOfBeds;
		this.numberOfAvailableBeds = numberOfAvailableBeds;
	}

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

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public int getNumberOfAvailableBeds() {
		return numberOfAvailableBeds;
	}

	public void setNumberOfAvailableBeds(int numberOfAvailableBeds) {
		this.numberOfAvailableBeds = numberOfAvailableBeds;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

}

/* INSERT INTO `room` VALUES (1,'General',5000,'Vacant') */
