package com.handymen;

public class Gettersetter {
	private Long id;
	private String username, email, password,field, charges, phoneno, address, city;

	public static Gettersetter getInstance(){
        return new Gettersetter();
    }

	public void setData(String username, String email, String password, String field, String charges, String phoneno, String address,String city)
	{
		this.username = username;
		this.email = email;
		this.password = password;
		this.field = field;
		this.charges = charges;
		this.phoneno = phoneno;
		this.address = address;
		this.city= city;
		
		
		}

	public void setID(Long id) {
		this.id = id;
	}



	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setField(String field) {
		this.field = field;
	}
	public void setCharges(String charges) {
		this.charges = charges;
	}
	
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
    
	public long getID() {
		return id;
	}


	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getField() {
		return field;
	}
	public String getCharges() {
		return charges;
	}
	
	public String getPhoneno() {
		return phoneno;
	}
		
		public String getAddress() {
		return address;
	}
		public String getCity() {
		return city;
		}
	
}
	




