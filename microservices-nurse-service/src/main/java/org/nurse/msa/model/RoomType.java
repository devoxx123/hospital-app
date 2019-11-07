package org.nurse.msa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM_TYPE_TBL")
public class RoomType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roomTypeId;
	private String typeOfroom;
	private double roomCost;

	public RoomType() {
	}

	public RoomType(Integer roomTypeId, String typeOfroom, double roomCost) {
		super();
		this.roomTypeId = roomTypeId;
		this.typeOfroom = typeOfroom;
		this.roomCost = roomCost;
	}

	public Integer getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getTypeOfroom() {
		return typeOfroom;
	}

	public void setTypeOfroom(String typeOfroom) {
		this.typeOfroom = typeOfroom;
	}

	public double getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(double roomCost) {
		this.roomCost = roomCost;
	}

}
