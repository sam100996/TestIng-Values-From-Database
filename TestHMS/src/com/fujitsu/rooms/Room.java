package com.fujitsu.rooms;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fujitsu.hotels.Hotel;

/*
 * Author:Satyam Tiwari
 * Creation Date:03/04/2019 (DD/MM/YYYY)
 * Modification Date:03/04/2019 (DD/MM/YYYY)
 * Version:1.0
 * Description:It is java bean class which represents Database Entity
 *  	       It is also Value Object Class
 * Copyright:Fujitsu Consulting India Pvt.Ltd.All rights reserved.
 */
//Java Beans class-Entity Class

@Entity
@Table(name="ROOMS")
public class Room implements Comparable<Room>,Serializable{

	
		@Id
		@GeneratedValue(generator="increment")
		@Column(length=10,name="ROOM_ID")
		private int roomId;
		
		@Column(length=10,nullable=false,unique=true)
		private String roomType;
		
		@Column(length=3,nullable=false,unique=true)
		private String availability;
		
		@Column(length=10,nullable=false)
		private float roomprice;
		
		private Blob roomphoto;

		@ManyToOne(cascade=CascadeType.ALL)
		private Hotel hotel;
		

		//Getter and Setter
		public float getRoomprice() {
			return roomprice;
		}


		public void setRoomprice(float roomprice) {
			this.roomprice = roomprice;
		}


		public Blob getRoomphoto() {
			return roomphoto;
		}


		public void setRoomphoto(Blob roomphoto) {
			this.roomphoto = roomphoto;
		}


		public int getRoomId() {
			return roomId;
		}


		public void setRoomId(int roomId) {
			this.roomId = roomId;
		}


		public String getRoomType() {
			return roomType;
		}


		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}

		public String getAvailability() {
			return availability;
		}

		public void setAvailability(String availability) {
			this.availability = availability;
		}

		public Hotel getHotel() {
			return hotel;
		}



		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}



		public Room() {
			// TODO Auto-generated constructor stub
		}
		
		

		public Room(int roomId, String roomType, String availability, float roomprice, Blob roomphoto) {
			super();
			this.roomId = roomId;
			this.roomType = roomType;
			this.availability = availability;
			this.roomprice = roomprice;
			this.roomphoto = roomphoto;
		}



		@Override
		public String toString() {
			return "Room [roomId=" + roomId + ", roomType=" + roomType + ", availability=" + availability
					+ ", roomprice=" + roomprice + ", roomphoto=" + roomphoto + "]";
		}


		@Override
		public int compareTo(Room r) {
			// TODO Auto-generated method stub
			return  this.roomId>r.roomId?1:-1;
	}
}
