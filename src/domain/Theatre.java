package domain;

public class Theatre {

	/**
	 * The id of the theatre
	 */
	private int theatreID;
	
	/**
	 * List of auditoriums in the theatre
	 */
	private Auditorium[] auditoriums;
	
	/**
	 * The contact phone number of the theatre
	 */
	private String phoneNumber;
	
	// Getters and Setters
	public int getTheatreID() {
		return theatreID;
	}
	public void setTheatreID(int theatreID) {
		this.theatreID = theatreID;
	}
	
	public Auditorium[] getAuditoriums() {
		return auditoriums;
	}
	public void setAuditoriums(Auditorium [] auditoriums){
		this.auditoriums = auditoriums;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
};
