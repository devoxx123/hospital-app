package org.nurse.msa.repository;

import java.util.List;

import org.nurse.msa.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepositroy extends JpaRepository<Room, Long> {

	public Room findByRoomNumber(String roomNumber);

	public List<Room> findAll();

}
