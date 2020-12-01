package domain.model;

import domain.model.Date;

public class Announcement {
	private Date privateAnnounceDate;

	private Date publicAnnounceDate;
	private String announceMessage;

	public Announcement(Date privateD, Date publicD, String m) {
		privateAnnounceDate = privateD;
		publicAnnounceDate = publicD;
		announceMessage = m;
	}

	public String getAnnounceMessage() {
		return announceMessage;
	}

	public void setAnnounceMessage(String m) {
		announceMessage = m;
	}

	public Date getPrivateAnnounceDate() { return privateAnnounceDate; }

	public void setPrivateAnnounceDate(Date privateAnnounceDate) { this.privateAnnounceDate = privateAnnounceDate; }

	public Date getPublicAnnounceDate() { return publicAnnounceDate; }

	public void setPublicAnnounceDate(Date publicAnnounceDate) { this.publicAnnounceDate = publicAnnounceDate; }
	
	@Override
	public String toString() {
		if(publicAnnounceDate.beforeCurrentDate() == true) {
			return String.format(getPublicAnnounceDate().toString() + "        Public Announcement: " + getAnnounceMessage());

		}else if(privateAnnounceDate.beforeCurrentDate() == true) {
			return String.format(getPrivateAnnounceDate().toString() + "        Private Announcement: " + getAnnounceMessage());
		}
		return "Not yet announced";
	}
	
}
