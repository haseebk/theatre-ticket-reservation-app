package database;

import domain.model.Movie;
import domain.model.RegisteredUser;
import domain.model.BankingInfo;
import domain.model.Date;
import domain.model.Showtime;
import domain.model.Theatre;
import domain.model.Auditorium;
import java.util.ArrayList;
import domain.model.Ticket;
import domain.model.Announcement;
import domain.model.Payment;

public class DatabasePopulator {
	DataController dbController;
	private Movie spiderverse;
	private Movie getout;
	private Movie hereditary;
	private Movie paddington;
	private Showtime s1;
	private Showtime s2;
	
	public DatabasePopulator() {
		dbController = DataController.getOnlyInstance();
	}
	
	public void loadDatabase() {
		loadMovies();
		loadTheatres();
		//loadShowtimes();
		loadAnnouncements();
		loadUsers();
		loadTickets();
	}
	
	public void loadMovies() {
		spiderverse = new Movie("Spider-Man: Into the Spider-Verse","Action", 2018, "Peter Ramsey", 116, 8.4);
		getout = new Movie("Get Out","Thriller", 2017, "Peter Ramsey", 104, 7.7);
		hereditary = new Movie("Hereditary","Horror", 2018, "Ari Aster", 127, 7.3);
		paddington = new Movie("Paddington 2","Adventure", 2017, "Paul King", 104, 7.8);

		dbController.addMovie(spiderverse);
		dbController.addMovie(getout);
		dbController.addMovie(hereditary);
		dbController.addMovie(paddington);
	}
	
	public void loadTheatres() {
		
		ArrayList<Auditorium> a1 = new ArrayList<Auditorium>(2);
		ArrayList<Auditorium> a2 = new ArrayList<Auditorium>(2);
		a1.add(new Auditorium(4, 6));
		a1.add(new Auditorium(6, 6));
		a2.add(new Auditorium(9, 7));
		a2.add(new Auditorium(7, 8));
		
		Theatre t1 = new Theatre("Theatre 1", 1, a1, "123456789");
		Theatre t2 = new Theatre("Theatre 2", 2, a2, "987654321");
		loadShowtimes(a1, a2);

		a1.get(0).setTheatre(t1);
		a1.get(1).setTheatre(t1);
		a2.get(0).setTheatre(t2);
		a2.get(1).setTheatre(t2);
		
		dbController.addTheatre(t1);
		dbController.addTheatre(t2);
	}
	
	public void loadShowtimes(ArrayList<Auditorium> x, ArrayList<Auditorium> y) {
		Date d1 = new Date(10, "December", 2020);
		Date d2 = new Date(12, "December", 2020);
		Date d3 = new Date(14, "December", 2020);
		Date d4 = new Date(16, "December", 2020);
		s1 = new Showtime(d1,x.get(0),spiderverse);
		s2 = new Showtime(d2,x.get(1),getout);
		Showtime s3 = new Showtime(d3,y.get(0),hereditary);
		Showtime s4 = new Showtime(d4,y.get(1),paddington);
		
		dbController.addShowtime(s1);
		dbController.addShowtime(s2);
		dbController.addShowtime(s3);
		dbController.addShowtime(s4);
	}
	
	public void loadTickets() {
		BankingInfo b1 = new BankingInfo("Vaibhav Kapoor", "MASTER","1111111111111111","111","01/22");
		BankingInfo b2 = new BankingInfo("William Kerr", "VISA","2222222222222222","222","02/22");
		Payment p1 = new Payment(1, 13.99, b1);
		Payment p2 = new Payment(2, 15.99, b2);
		Ticket t1 = new Ticket(12, p1, s1.getMovie(), s1, s1.getSeats()[1][2]);
		Ticket t2 = new Ticket(13, p2, s2.getMovie(), s2, s2.getSeats()[3][3]);
		
		dbController.addTicket(t1);
		dbController.addTicket(t2);
	}
	
	public void loadUsers() {
		BankingInfo b1 = new BankingInfo("Vaibhav Kapoor", "MASTER","1111111111111111","111","01/22");
		BankingInfo b2 = new BankingInfo("William Kerr", "VISA","2222222222222222","222","02/22");
		BankingInfo b3 = new BankingInfo("Eddie Kim", "VISA","3333333333333333","333","03/22");
		BankingInfo b4 = new BankingInfo("Haseeb Khan", "MASTER","4444444444444444","444","04/22");
		Date d1 = new Date(1,"April", 2020);
		Date d2 = new Date(2, "May", 2020);
		Date d3 = new Date(3, "June", 2020);
		Date d4 = new Date(4, "July", 2020);
		RegisteredUser u1 = new RegisteredUser("V.Kapoor", "1234", "Vaibhav", "Kapoor", "vk@email.com", b1, d1);
		RegisteredUser u2 = new RegisteredUser("W.Kerr", "1235", "William", "Kerr", "wk@email.com", b2, d2);
		RegisteredUser u3 = new RegisteredUser("E.Kim", "1236", "Eddie", "Kim", "ek@email.com", b3, d3);
		RegisteredUser u4 = new RegisteredUser("H.Khan", "1237", "Haseeb", "Khan", "hk@email.com", b4, d4);
		
		dbController.addUser(u1);
		dbController.addUser(u2);
		dbController.addUser(u3);
		dbController.addUser(u4);
	}
	
	public void loadAnnouncements() {
		Date da1 = new Date(7, "December", 2020);
		Date da2 = new Date(8, "December", 2020);
		Announcement an1 = new Announcement(da1, "This is the first announcement.");
		Announcement an2 = new Announcement(da2, "This is the second announcement.");
		
		dbController.addAnnouncement(an1);
		dbController.addAnnouncement(an2);
	}
}
