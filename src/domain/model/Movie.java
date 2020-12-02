package domain.model;

public class Movie {

	private int movieID;
	private static int movieCounter = 1000;

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
	
	private double price;
	
	private String synopsis;

	private Announcement movieAnnouncement;

	public Movie(String title, String genre, int year, String director, double movieLength, double rating, String poster, double p, String syn) {
		this.movieID = movieCounter++;
		this.title = title;
		this.genre = genre;
		this.year = year;
		this.director = director;
		this.movieLength = movieLength;
		this.rating = rating;
		this.setPoster(poster);
		this.setPrice(p);
		this.synopsis = syn;
		this.movieAnnouncement = null;
	}

	public Movie(int id,String title, String genre, int year, String director, double movieLength, double rating, String poster, double p, String syn) {
		this.movieID = id;
		movieCounter++;
		this.title = title;
		this.genre = genre;
		this.year = year;
		this.director = director;
		this.movieLength = movieLength;
		this.rating = rating;
		this.setPoster(poster);
		this.setPrice(p);
		this.synopsis = syn;
		this.movieAnnouncement = null;
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
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Announcement getMovieAnnouncement() { return movieAnnouncement; }

	public void setMovieAnnouncement(Announcement movieAnnouncement) { this.movieAnnouncement = movieAnnouncement; }

	public int getMovieID() { return movieID; }

	@Override
	public String toString() {
		return String.format(title);
	}

};
