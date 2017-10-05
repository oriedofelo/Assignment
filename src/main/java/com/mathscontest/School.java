package com.mathscontest;

public class School {
	private String name;
	private String registrationID;
	
	public School(String _name, String _regId)
	{
		name = _name;
		registrationID = _regId;
                System.out.println("Successfully registered "+_name);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistrationID() {
		return registrationID;
	}

	public void setRegistrationID(String registrationID) {
		this.registrationID = registrationID;
	}
	

}
