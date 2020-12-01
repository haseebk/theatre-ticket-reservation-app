package domain.model;

import domain.model.Date;

public class Announcement {
	private Date announceDate;
	private String announceMessage;

	public Announcement(Date d, String m) {
		announceDate = d;
		announceMessage = m;
	}

	public Announcement(int day, String month, int year, String m) {
		announceDate = new Date(day, month, year);
		announceMessage = m;
	}

	public Date getAnnounceDate() {
		return announceDate;
	}

	public void setAnnounceDate(Date d) {
		announceDate = d;
	}

	public String getAnnounceMessage() {
		return announceMessage;
	}

	public void setAnnounceMessage(String m) {
		announceMessage = m;
	}
	
	@Override
	public String toString() {
		return String.format(getAnnounceDate().month + " " + getAnnounceDate().day + ", " + getAnnounceDate().year + "        " + getAnnounceMessage());
	}
	
}
