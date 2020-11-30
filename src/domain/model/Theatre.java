package domain.model;

import java.util.ArrayList;

public class Theatre {

	//Name of the theatre
	private String t_name;

	/**
	 * The id of the theatre
	 */
	private int theatreID;

	/**
	 * List of auditoriums in the theatre
	 */
	private ArrayList<Auditorium> auditoriums;

	/**
	 * The contact phone number of the theatre
	 */
	private String phoneNumber;

	public Theatre() {
		theatreID = 0;
		setAuditoriums(new ArrayList<Auditorium>());
	}

	public Theatre(String theatreName, int theatreID, ArrayList<Auditorium> auditoriums, String phoneNumber) {
		this.t_name = theatreName;
		this.theatreID = theatreID;
		this.setAuditoriums(auditoriums);
		this.phoneNumber = phoneNumber;
	}

	// Getters and Setters
	public String getT_name() {return t_name; }

	public void setT_name(String t_name) {this.t_name = t_name;
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

};