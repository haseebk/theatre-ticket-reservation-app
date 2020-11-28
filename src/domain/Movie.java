
public class Movie {
	
	/**
	 * Movie title
	 */
	private String title;
	
	/**
	 * Movie genre
	 */
	private String genre;
	
	/**
	 * Movie released year
	 */
	private int year;
	
	/**
	 * Movie director name
	 */
	private String director;
	
	/**
	 * Length of movie in minutes
	 */
	private double m_length;
	
	/**
	 * Rating of the movie
	 */
	private String rating;
	
	// Getters and Setters
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public double getM_length() {
		return m_length;
	}
	public void setM_length(double m_length) {
		this.m_length = m_length;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
};
