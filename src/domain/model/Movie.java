package domain.model;

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
	private double movieLength;

	/**
	 * Rating of the movie
	 */
	private double rating;

	private String poster;

	private Movie() {
		this.title = "";
		this.genre = "";
		this.year = 0;
		this.director = "";
		this.movieLength = 0;
		this.rating = 0.0;
		this.setPoster("");
	}

	public Movie(String title, String genre, int year, String director, int movieLength, double rating, String poster) {
		this.title = title;
		this.genre = genre;
		this.year = year;
		this.director = director;
		this.movieLength = movieLength;
		this.rating = rating;
		this.setPoster(poster);
	}

	// Getters and Setters
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(double movieLength) {
		this.movieLength = movieLength;
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

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
};
