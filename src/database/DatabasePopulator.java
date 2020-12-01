package database;

import domain.model.Movie;
import domain.model.RegisteredUser;
import domain.model.BankingInfo;
import domain.model.Date;
import domain.model.FinancialInstitution;
import domain.model.Showtime;
import domain.model.Theatre;
import domain.model.Auditorium;
import java.util.ArrayList;
import domain.model.Ticket;
import domain.model.Announcement;
import domain.model.Payment;
import domain.model.Voucher;

public class DatabasePopulator {
	DataController dbController;
	private Movie spiderverse;
	private Movie getout;
	private Movie hereditary;
	private Movie paddington;
	private Showtime s1;
	private Showtime s2;
	private FinancialInstitution inst;
	private BankingInfo b1;
	private BankingInfo b2;
	private BankingInfo b3;
	private BankingInfo b4;
	

	public DatabasePopulator() {
		dbController = DataController.getOnlyInstance();
	}

	public void loadDatabase() {
		loadMovies();
		loadTheatres();
		// loadShowtimes();
		loadAnnouncements();
		loadUsers();
		loadTickets();
		loadVouchers();
		loadInst();
	}

	public void loadInst() {
		inst = new FinancialInstitution("Cash Money Bank");
		BankingInfo b5 = new BankingInfo("Random Person", "VISA", "5555555555555555", "555", "05/22");
		inst.addAccount(b1);
		inst.addAccount(b2);
		inst.addAccount(b3);
		inst.addAccount(b4);
		inst.addAccount(b5);
	}
	
	public void loadMovies() {
		String s= "After gaining superpowers from a spider bite, Miles Morales protects the cirty as Spider-Man. Soon, he meets alternate version of himself and gets embroiled in an epic battle to save the multiverse.";
		String g = "Chris, an African-American man, decides to visit his Caucasian girlfriend's parents during a weekend getaway. Although they seem normal at first, he is not prepared to experience the horrors ahead.";
		String h = "When the matriarch of the Graham family passes away, her daughter and grandchildren begin to unravel cryptic and increasingly terrifying secrets about their ancestry, tyring to outrun the sinister fate they have inherited.";
		String p = "Paddington takes up a job to accumulate enough money to buy the perfect gift for his anunt on her 100th birthday, but it gets stolen.";
		spiderverse = new Movie("Spider-Man: Into the Spider-Verse", "Action", 2018, "Peter Ramsey", 116, 8.4,
				"spm-poster-183x268", 12.99, s);
		getout = new Movie("Get Out", "Thriller", 2017, "Peter Ramsey", 104, 7.7, "get-poster-183x268", 12.99, g);
		hereditary = new Movie("Hereditary", "Horror", 2018, "Ari Aster", 127, 7.3, "her-poster-183x268",12.99, h);
		paddington = new Movie("Paddington 2", "Adventure", 2017, "Paul King", 104, 7.8, "pd2-poster-183x268",12.99, p);

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

		Theatre t1 = new Theatre("Theatre 1", 1, a1, "123456789", " Some Address 1");
		Theatre t2 = new Theatre("Theatre 2", 2, a2, "987654321", "Some Address 2");
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
		
		s1 = new Showtime(d1, x.get(0), spiderverse);
		Showtime s11 = new Showtime(d3, x.get(0), spiderverse);
		
		s2 = new Showtime(d2, x.get(1), getout);
		Showtime s12 = new Showtime(d4, x.get(0), getout);
		
		Showtime s3 = new Showtime(d3, x.get(0), hereditary);
		Showtime s13 = new Showtime(d1, x.get(1), hereditary);
		
		Showtime s4 = new Showtime(d4, x.get(1), paddington);
		Showtime s9 = new Showtime(d2, x.get(1), paddington);
		
		Showtime s5 = new Showtime(d1, y.get(0), spiderverse);
		Showtime s10 = new Showtime(d3, y.get(1), spiderverse);
		
		Showtime s6 = new Showtime(d2, y.get(1), getout);
		Showtime s14 = new Showtime(d3, y.get(1), getout);
		
		Showtime s7 = new Showtime(d3, y.get(0), hereditary);
		Showtime s15 = new Showtime(d1, y.get(1), hereditary);
		
		Showtime s8 = new Showtime(d4, y.get(1), paddington);
		Showtime s16 = new Showtime(d2, y.get(1), paddington);

		dbController.addShowtime(s1);
		dbController.addShowtime(s2);
		dbController.addShowtime(s3);
		dbController.addShowtime(s4);
		dbController.addShowtime(s5);
		dbController.addShowtime(s6);
		dbController.addShowtime(s7);
		dbController.addShowtime(s8);
		dbController.addShowtime(s9);
		dbController.addShowtime(s10);
		dbController.addShowtime(s11);
		dbController.addShowtime(s12);
		dbController.addShowtime(s13);
		dbController.addShowtime(s14);
		dbController.addShowtime(s15);
		dbController.addShowtime(s16);
	}

	public void loadTickets() {
		b1 = new BankingInfo("Vaibhav Kapoor", "MASTER", "1111111111111111", "111", "01/22");
		b2 = new BankingInfo("William Kerr", "VISA", "2222222222222222", "222", "02/22");
		Payment p1 = new Payment(1, 13.99, b1);
		Payment p2 = new Payment(2, 15.99, b2);
		Ticket t1 = new Ticket(12, p1, s1.getMovie(), s1, s1.getSeats()[1][2]);
		Ticket t2 = new Ticket(13, p2, s2.getMovie(), s2, s2.getSeats()[3][3]);
		s1.getSeats()[1][2].bookSeat();
		s2.getSeats()[3][3].bookSeat();

		dbController.addTicket(t1);
		dbController.addTicket(t2);
	}

	public void loadUsers() {
		//b1 = new BankingInfo("Vaibhav Kapoor", "MASTER", "1111111111111111", "111", "01/22");
		//b2 = new BankingInfo("William Kerr", "VISA", "2222222222222222", "222", "02/22");
		b3 = new BankingInfo("Eddie Kim", "VISA", "3333333333333333", "333", "03/22");
		b4 = new BankingInfo("Haseeb Khan", "MASTER", "4444444444444444", "444", "04/22");
		Date d1 = new Date(1, "April", 2020);
		Date d2 = new Date(2, "May", 2020);
		Date d3 = new Date(3, "June", 2020);
		Date d4 = new Date(4, "July", 2020);
		RegisteredUser u1 = new RegisteredUser("V.Kapoor", "1234", "Vaibhav", "Kapoor", "vk@email.com", b1, d1);
		RegisteredUser u2 = new RegisteredUser("W.Kerr", "1234", "William", "Kerr", "wk@email.com", b2, d2);
		RegisteredUser u3 = new RegisteredUser("E.Kim", "1234", "Eddie", "Kim", "ek@email.com", b3, d3);
		RegisteredUser u4 = new RegisteredUser("H.Khan", "1234", "Haseeb", "Khan", "hk@email.com", b4, d4);

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
	
	public void loadVouchers() {
		
	}
}
