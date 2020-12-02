package database;

import domain.model.Movie;
import domain.model.RegisteredUser;
import domain.model.BankingInfo;
import domain.model.Date;
import domain.model.FinancialInstitution;
import domain.model.Showtime;
import domain.model.Theatre;
import domain.model.Auditorium;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import domain.model.Ticket;
import domain.model.Announcement;
import domain.model.Payment;
import domain.model.Voucher;

public class DatabasePopulator{
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

	public void loadDatabase() throws IOException{
		loadMovies();
		loadTheatres();
		loadAnnouncements();
		loadTickets();
		loadUsers();
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
		dbController.setInst(inst);
	}
	
	public void loadMovies() throws IOException {
		FileInputStream fstream = new FileInputStream("data/movie_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[11];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			dbController.addMovie(new Movie(Integer.parseInt(argList[0]),argList[1],argList[2],Integer.parseInt(argList[3]),
					argList[4],Integer.parseInt(argList[5]),Double.parseDouble(argList[6]),argList[7],Double.parseDouble(argList[8]),argList[9]));
		}
		fstream.close();

		spiderverse = dbController.getMovieList().get(0);
		getout = dbController.getMovieList().get(1);
		hereditary = dbController.getMovieList().get(2);
		paddington = dbController.getMovieList().get(3);
	}

	public void loadTheatres() throws IOException{
		FileInputStream fstream = new FileInputStream("data/theatre_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[4];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
			}
			dbController.addTheatre(new Theatre(Integer.parseInt(argList[0]), argList[1], argList[2], argList[3]));
		}
		fstream.close();
		loadAuditoriums();
	}

	public void loadAuditoriums() throws IOException {
		FileInputStream fstream = new FileInputStream("data/auditorium_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[4];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
			}
			dbController.addAuditorium(new Auditorium(Integer.parseInt(argList[0]), Integer.parseInt(argList[1]), Integer.parseInt(argList[2]), dbController.searchTheatre(Integer.parseInt(argList[3]))));
		}
		fstream.close();

		loadShowtimes();
	}



	public void loadShowtimes() throws IOException{
		FileInputStream fstream = new FileInputStream("data/showtime_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[8];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
			}

			Movie foundMovie = dbController.searchMovie(Integer.parseInt(argList[1]));
			Auditorium foundAuditorium = dbController.searchAuditorium(Integer.parseInt(argList[2]));
			Date foundDate = new Date(Integer.parseInt(argList[3]),Integer.parseInt(argList[4]),Integer.parseInt(argList[5]));
			dbController.addShowtime(new Showtime(Integer.parseInt(argList[0]),foundMovie,foundAuditorium,
					foundDate,Integer.parseInt(argList[6]),Integer.parseInt(argList[7])));
		}
		fstream.close();

		s1 = dbController.getShowtimeList().get(0);
		s2 = dbController.getShowtimeList().get(1);
	}

	public void loadTickets() {
		b1 = new BankingInfo("Vaibhav Kapoor", "MASTER", "1111111111111111", "111", "01/22");
		b2 = new BankingInfo("William Kerr", "VISA", "2222222222222222", "222", "02/22");
		Payment p1 = new Payment(13.99, b1);
		Payment p2 = new Payment(15.99, b2);
		Ticket t1 = new Ticket(p1, s1.getMovie(), s1, s1.getSeats()[1][2]);
		Ticket t2 = new Ticket(p2, s2.getMovie(), s2, s2.getSeats()[3][3]);
		s1.bookSeat(1,2);
		s2.bookSeat(3,3);

		dbController.addTicket(t1);
		dbController.addTicket(t2);
	}

	public void loadUsers() {
		b3 = new BankingInfo("Eddie Kim", "VISA", "3333333333333333", "333", "03/22");
		b4 = new BankingInfo("Haseeb Khan", "MASTER", "4444444444444444", "444", "04/22");
		Date d1 = new Date(1, 4, 2020);
		Date d2 = new Date(2, 5, 2020);
		Date d3 = new Date(3, 6, 2020);
		Date d4 = new Date(4, 7, 2020);
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
		Date da1 = new Date(29, 11, 2020);
		Date da2 = new Date(20, 12, 2020);
		Date da3 = new Date(15, 12, 2020);
		Date da4 = new Date(27, 12, 2020);
		Date da5 = new Date(20, 11, 2020);
		Date da6 = new Date(29, 11, 2020);
		Date da7 = new Date(15, 11, 2020);
		Date da8 = new Date(27, 11, 2020);
		Announcement an1 = new Announcement(da1,da2, spiderverse);
		Announcement an2 = new Announcement(da3,da4, hereditary);
		Announcement an3 = new Announcement(da5,da6, getout);
		Announcement an4 = new Announcement(da7,da8, paddington);

		dbController.addAnnouncement(an1);
		dbController.addAnnouncement(an2);
		dbController.addAnnouncement(an3);
		dbController.addAnnouncement(an4);
	}
	
	public void loadVouchers() {
		
	}
}
