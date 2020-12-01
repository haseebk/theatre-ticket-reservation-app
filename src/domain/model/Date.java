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
	 * @return true if it is before the current date or the same as the current date, false if it is after the current date
	 */
	public boolean beforeCurrentDate(){
		LocalDate todaysDate = LocalDate.now();
		System.out.println(todaysDate.getYear() + " vs. " + year);
		if(year < todaysDate.getYear()){
			return true;
		}
		if(year > todaysDate.getYear()){
			return false;
		}
		System.out.println(todaysDate.getMonthValue() + " vs. " + month);
		if(month < todaysDate.getMonthValue()){
			return true;
		}
		if(month > todaysDate.getMonthValue()){
			return false;
		}
		System.out.println(todaysDate.getDayOfMonth() + " vs. " + day);
		if(day < todaysDate.getDayOfMonth()){
			return true;
		}
		if(day > todaysDate.getDayOfMonth()){
			return false;
		}
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
