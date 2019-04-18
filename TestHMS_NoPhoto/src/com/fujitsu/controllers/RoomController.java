package com.fujitsu.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fujitsu.exceptions.ServiceException;
import com.fujitsu.rooms.Room;
import com.fujitsu.services.RoomService;



@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping("/rooms")
	public String viewAllrooms(HttpSession session) {

		try {
			List<Room> rooms =roomService.findAllRooms();
			session.setAttribute("roomList", rooms);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "roomview";
	}
	
	@GetMapping("/addr")
	public String addRoomForm() {
		return "roomaddform";
	}


	@PostMapping("/addRoom")
	public String addRoom(Room room, ModelMap map) {

		try {
			roomService.add(room);
			map.addAttribute("room",room);
			return "success";
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.addAttribute("addroomerror", "Sorry! room could not find");
			return "roomaddform";
		}


	}
	
	}













