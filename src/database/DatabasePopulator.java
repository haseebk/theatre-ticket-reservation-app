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
		loadBankInfo();
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

	public void loadUsers() throws IOException{
		FileInputStream fstream = new FileInputStream("data/registered_user_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[10];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
			}

			Date foundDate = new Date(Integer.parseInt(argList[7]),Integer.parseInt(argList[8]),Integer.parseInt(argList[9]));
			dbController.addUser(new RegisteredUser(Integer.parseInt(argList[0]),argList[1],argList[2],argList[3],argList[4],argList[5],dbController.searchBankingInfo(Integer.parseInt(argList[6])),foundDate));
		}
		fstream.close();
	}

	public void loadAnnouncements() throws IOException{
		FileInputStream fstream = new FileInputStream("data/announcement_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[8];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
			}
			Date foundDate1 = new Date(Integer.parseInt(argList[1]),Integer.parseInt(argList[2]),Integer.parseInt(argList[3]));
			Date foundDate2 = new Date(Integer.parseInt(argList[4]),Integer.parseInt(argList[5]),Integer.parseInt(argList[6]));
			Movie foundMovie = dbController.searchMovie(Integer.parseInt(argList[7]));
			Announcement temp = new Announcement(Integer.parseInt(argList[0]),foundDate1,foundDate2,foundMovie);
			dbController.addAnnouncement(temp);
			foundMovie.setMovieAnnouncement(temp);
		}
		fstream.close();
	}

	public void loadBankInfo() throws IOException{
		FileInputStream fstream = new FileInputStream("data/banking_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[8];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
			}
			dbController.addBankingInfo(new BankingInfo(Integer.parseInt(argList[0]), argList[1], argList[2], argList[3], argList[4], argList[5]));
		}
	}
	
	public void loadVouchers() {
		
	}
}
