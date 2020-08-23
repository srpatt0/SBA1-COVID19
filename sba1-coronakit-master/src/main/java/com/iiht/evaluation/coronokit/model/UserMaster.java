package com.iiht.evaluation.coronokit.model;

public class UserMaster {	
		
		private int id;
		private String personName;
		private String email;
		private String contactNumber;
		private String deliveryAddress;
		
		public UserMaster(String personName, String email, String contactNumber,
				String deliveryAddress) {
			// TODO Auto-generated constructor stub
			this.personName = personName;
			this.email = email;
			this.contactNumber = contactNumber;
			this.deliveryAddress = deliveryAddress;
		}
		
		public UserMaster(int id, String personName, String email, String contactNumber,
				String deliveryAddress) {
			this.id = id;
			this.personName = personName;
			this.email = email;
			this.contactNumber = contactNumber;
			this.deliveryAddress = deliveryAddress;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPersonName() {
			return personName;
		}
		public void setPersonName(String personName) {
			this.personName = personName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		
		public String getDeliveryAddress() {
			return deliveryAddress;
		}
		public void setDeliveryAddress(String deliveryAddress) {
			this.deliveryAddress = deliveryAddress;
		}	
		

	}