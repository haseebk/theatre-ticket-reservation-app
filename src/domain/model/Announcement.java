package domain.model;

import domain.model.Date;

public class Announcement {
<<<<<<< HEAD

	private int announcementID;
	private static int announcementCounter = 7000;

	private Date privateAnnounceDate;

	private Date publicAnnounceDate;
	private String announceMessage;

	private Movie movieAnnouncement;

	public Announcement(Date privateD, Date publicD, Movie mov) {
		announcementID = announcementCounter++;
		privateAnnounceDate = privateD;
		publicAnnounceDate = publicD;
		announceMessage = mov.getTitle() + " avaliable in Theatres: " + publicAnnounceDate.toString();
		movieAnnouncement = mov;
		mov.setMovieAnnouncement(this);
	}
	public Announcement(int id,Date privateD, Date publicD, Movie mov) {
		announcementID = id;
		announcementCounter++;
		privateAnnounceDate = privateD;
		publicAnnounceDate = publicD;
		announceMessage = mov.getTitle() + " avaliable in Theatres: " + publicAnnounceDate.toString();
=======
	private Date privateAnnounceDate;

	private Date publicAnnounceDate;
	private String announceMessage;

	private Movie movieAnnouncement;

	public Announcement(Date privateD, Date publicD, String m, Movie mov) {
		privateAnnounceDate = privateD;
		publicAnnounceDate = publicD;
		announceMessage = m;
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb
		movieAnnouncement = mov;
		mov.setMovieAnnouncement(this);
	}

	public String getAnnounceMessage() {
		return announceMessage;
	}

	public void setAnnounceMessage(String m) {
		announceMessage = m;
	}

<<<<<<< HEAD
	//returns true if it is private
	public boolean isPrivateOnly(){
		return (!privateAnnounceDate.beforeCurrentDate() && publicAnnounceDate.beforeCurrentDate());
	}

	//returns true if it is public
	public boolean isPublic(){
		return !publicAnnounceDate.beforeCurrentDate();
	}

=======
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb
	public Date getPrivateAnnounceDate() { return privateAnnounceDate; }

	public void setPrivateAnnounceDate(Date privateAnnounceDate) { this.privateAnnounceDate = privateAnnounceDate; }

	public Date getPublicAnnounceDate() { return publicAnnounceDate; }

	public void setPublicAnnounceDate(Date publicAnnounceDate) { this.publicAnnounceDate = publicAnnounceDate; }
<<<<<<< HEAD

	public int getAnnouncementID() { return announcementID; }
	
	@Override
	public String toString() {
		if(publicAnnounceDate.beforeCurrentDate() == false) {
			return String.format(getPublicAnnounceDate().toString() + "        Public Announcement: " + getAnnounceMessage());

		}else if(privateAnnounceDate.beforeCurrentDate() == false) {
=======
	
	@Override
	public String toString() {
		if(publicAnnounceDate.beforeCurrentDate() == true) {
			return String.format(getPublicAnnounceDate().toString() + "        Public Announcement: " + getAnnounceMessage());

		}else if(privateAnnounceDate.beforeCurrentDate() == true) {
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb
			return String.format(getPrivateAnnounceDate().toString() + "        Private Announcement: " + getAnnounceMessage());
		}
		return "Not yet announced";
	}
	
}
