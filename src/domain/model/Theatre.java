package domain.model;

import java.util.ArrayList;

public class Theatre {

	// Name of the theatre
	private String t_name;

	/**
	 * The id of the theatre
	 */
	private int theatreID;
	private static int theatreCounter = 2000;
	/**
	 * List of auditoriums in the theatre
	 */
	private ArrayList<Auditorium> auditoriums;

	/**
	 * The contact phone number of the theatre
	 */
	private String phoneNumber;

	/**
	 * The address of the theatre
	 */
	private String address;

	public Theatre(int theatreID, String theatreName, String phoneNumber, String ad) {
		this.t_name = theatreName;
		this.theatreID = theatreID;
		if(theatreID> theatreCounter){
			theatreCounter = theatreID+1;
		}else {
			theatreCounter++;
		}
		this.setAuditoriums(new ArrayList<Auditorium>());
		this.phoneNumber = phoneNumber;
		this.address = ad;
	}

	public Theatre(String theatreName, ArrayList<Auditorium> auditoriums, String phoneNumber, String ad) {
		this.t_name = theatreName;
		this.theatreID = theatreCounter++;
		this.setAuditoriums(auditoriums);
		this.phoneNumber = phoneNumber;
		this.address = ad;
	}

	public Theatre(int theatreID, String theatreName, ArrayList<Auditorium> auditoriums, String phoneNumber, String ad) {
		this.t_name = theatreName;
		this.theatreID = theatreID;
		if(theatreID> theatreCounter){
			theatreCounter = theatreID+1;
		}else {
			theatreCounter++;
		}
		this.setAuditoriums(auditoriums);
		this.phoneNumber = phoneNumber;
		this.address = ad;
	}

	// Getters and Setters
	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public int getTheatreID() {
		return theatreID;
	}

	public void setTheatreID(int theatreID) {
		this.theatreID = theatreID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ArrayList<Auditorium> getAuditoriums() {
		return auditoriums;
	}

	public void setAuditoriums(ArrayList<Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

};
