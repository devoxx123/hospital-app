package org.nurse.msa.service;

import java.util.List;

import org.nurse.msa.dto.BedAllotmentDTO;
import org.nurse.msa.dto.NurseDTO;
import org.nurse.msa.dto.RoomDTO;

public interface NurseService {

	public BedAllotmentDTO createBedAllotment(BedAllotmentDTO bedAllotmentDTO);

	public List<BedAllotmentDTO> getAllBedAllotments();

	public BedAllotmentDTO getBedAllotmentByBedId(String bedId);

	public void deleteBedAllotmentByBedId(String bedId);

	public BedAllotmentDTO updateBedAllotment(String bedId, BedAllotmentDTO bedAllotmentDTO);

//	public RoomDTO createRoom(RoomDTO moomDTO);
//
//	public List<RoomDTO> getAllRooms();
//
//	public RoomDTO getRoomNumber(String roomNumber);
//
//	public void deleteRoomNumber(String roomNumber);
//
//	public RoomDTO updateRoom(String roomNumber, RoomDTO roomDTO);
//
//	public NurseDTO createNurse(NurseDTO nurseDTO);
//
//	public List<NurseDTO> getAllNurses();
//
//	public NurseDTO getNurseId(String getNurseId);
//
//	public void deleteNurseId(String getNurseId);
//
//	public NurseDTO updateNurse(String roomNumber, NurseDTO nurseDTO);

}
