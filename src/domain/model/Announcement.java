package domain.model;

import domain.model.Date;

public class Announcement {

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
		if(id > announcementCounter){
			announcementCounter = id+1;
		}else {
			announcementCounter++;
		}
		privateAnnounceDate = privateD;
		publicAnnounceDate = publicD;
		announceMessage = mov.getTitle() + " avaliable in Theatres: " + publicAnnounceDate.toString();
		movieAnnouncement = mov;
		mov.setMovieAnnouncement(this);
	}

	public String getAnnounceMessage() {
		return announceMessage;
	}

	public void setAnnounceMessage(String m) {
		announceMessage = m;
	}

	//returns true if it is private
	public boolean isPrivateOnly(){
		return (!privateAnnounceDate.beforeCurrentDate() && publicAnnounceDate.beforeCurrentDate());
	}

	//returns true if it is public
	public boolean isPublic(){
		return !publicAnnounceDate.beforeCurrentDate();
	}

	public Date getPrivateAnnounceDate() { return privateAnnounceDate; }

	public void setPrivateAnnounceDate(Date privateAnnounceDate) { this.privateAnnounceDate = privateAnnounceDate; }

	public Date getPublicAnnounceDate() { return publicAnnounceDate; }

	public void setPublicAnnounceDate(Date publicAnnounceDate) { this.publicAnnounceDate = publicAnnounceDate; }

	public int getAnnouncementID() { return announcementID; }
	public Movie getMovieAnnouncement() { return movieAnnouncement; }

	public void setMovieAnnouncement(Movie movieAnnouncement) { this.movieAnnouncement = movieAnnouncement; }

	
	@Override
	public String toString() {
		if(publicAnnounceDate.beforeCurrentDate() == false) {
			return String.format(getPublicAnnounceDate().toString() + "        Public Announcement: " + getAnnounceMessage());

		}else if(privateAnnounceDate.beforeCurrentDate() == false) {
			return String.format(getPrivateAnnounceDate().toString() + "        Private Announcement: " + getAnnounceMessage());
		}
		return "Not yet announced";
	}
	
}
