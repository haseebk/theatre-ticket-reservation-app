package domain.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Date {
	public int day;
	public int month;
	public int year;

	public Date(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}

	/**
	 * Sees if the date is before the current date
	 * @return true if it is before the current date, false if it is after the current date
	 */
	public boolean beforeCurrentDate(){
		LocalDate todaysDate = LocalDate.now();
		todaysDate.getMonthValue();
		return true;
	}

	public void setDate(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}

	@Override
	public String toString() {
		return (day + "/" + month + "/" + year);
	}

}
