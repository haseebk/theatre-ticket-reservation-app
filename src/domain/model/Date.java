package domain.model;

import java.text.DecimalFormat;
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

	public boolean checkIfCurrentDate(Date compareDate) {
		LocalDate todaysDate = LocalDate.now();
		if (todaysDate.getYear() == compareDate.getYear()) {
			if (todaysDate.getMonthValue() == compareDate.getMonth()) {
				if (todaysDate.getDayOfMonth() == compareDate.getDay()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Sees if the date is before the current date
	 * 
	 * @return true if it is before the current date or the same as the current
	 *         date, false if it is after the current date
	 */
	public boolean beforeCurrentDate() {
		LocalDate todaysDate = LocalDate.now();
		if (year > todaysDate.getYear()) {
			return true;
		}
		if (year < todaysDate.getYear()) {
			return false;
		}
		if (month > todaysDate.getMonthValue()) {
			return true;
		}
		if (month < todaysDate.getMonthValue()) {
			return false;
		}
		if (day > todaysDate.getDayOfMonth()) {
			return true;
		}
		if (day < todaysDate.getDayOfMonth()) {
			return false;
		}
		return true;
	}

	public void setDate(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}

	// Getters and setters
	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		DecimalFormat formatter = new DecimalFormat("00");
		String dayFormat = formatter.format(day);
		String monthFormat = formatter.format(month);
		String yearFormat = formatter.format(year);
		return (dayFormat + "/" + monthFormat + "/" + yearFormat);
	}

}
