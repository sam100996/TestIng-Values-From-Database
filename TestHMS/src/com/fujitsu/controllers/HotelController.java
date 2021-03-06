package com.fujitsu.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fujitsu.exceptions.ServiceException;
import com.fujitsu.hotels.Hotel;
import com.fujitsu.services.HotelService;

@Controller
public class HotelController {


	@Autowired
	private HotelService hotelService;

	@GetMapping("/hotels")
	public String viewAllhotels(HttpSession session) {

		try {

			List<Hotel> hotels =hotelService.findAllHotels();
			session.setAttribute("hotelList", hotels);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hotelview";
	}
	
	@GetMapping("/add")
	public String addHotelForm() {
		return "hoteladdform";
	}


	@RequestMapping("/addHotel")
	public String addHotel(Hotel hotel, ModelMap map) {

		try {
			hotelService.add(hotel);
			map.addAttribute("message", "HOTEL" + hotel.getHotelId() + "is saved successfully");
			return "success";
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.addAttribute("addhotelerror", "sorry! hotel could not find");
			return "hoteladdform";
		}
}
}
