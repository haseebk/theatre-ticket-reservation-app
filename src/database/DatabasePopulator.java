package database;

import domain.model.Movie;
import domain.model.RegisteredUser;
import domain.model.Seat;
import domain.model.BankingInfo;
import domain.model.Date;
import domain.model.FinancialInstitution;
import domain.model.Showtime;
import domain.model.Theatre;
import domain.model.Auditorium;

import java.io.BufferedReader;
import java.io.FileInputStream;
<<<<<<< HEAD
=======
import java.io.FileNotFoundException;
import java.io.FileReader;
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import domain.model.Ticket;
import domain.model.Announcement;
import domain.model.Payment;
import domain.model.Voucher;

<<<<<<< HEAD
public class DatabasePopulator{
=======
/**
 * Populates the data from text files
 * @author Eddie
 *
 */
public class DatabasePopulator {
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb
	DataController dbController;

	public DatabasePopulator() {
		dbController = DataController.getOnlyInstance();
	}

<<<<<<< HEAD
=======
	/**
	 * Constructor to load all the different data fields
	 * @throws IOException
	 */
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb
	public void loadDatabase() throws IOException{
		loadMovies();
		loadAuditoriums();
		loadTheatres();
<<<<<<< HEAD
		loadAnnouncements();
=======
		loadShowtimes();
		loadAnnouncements();
		loadBankAccount();
		loadUsers(); 
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb
		loadTickets();
		loadBankInfo();
		loadUsers();
		loadVouchers();
<<<<<<< HEAD
		loadInst();
	}

	public void loadInst() {
		System.out.println("\n****LOADING FINANCIAL INSTITUTIONS****");

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
		System.out.println("\n****LOADING MOVIES****");

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
		System.out.println("\n****LOADING THEATRES****");

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
		System.out.println("\n****LOADING AUDITORIUMS****");

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
=======
	}

	/**
	 * Loads movie data from movie_data.txt file
	 * @throws IOException
	 */
	public void loadMovies() throws IOException {
		
		FileInputStream fstream = new FileInputStream("data/movie_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String line;
		ArrayList<String> argList = new ArrayList<String>();
		
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		
		for(int i = 0; i < argList.size(); i+=9) {
			Movie tempMovie = new Movie(argList.get(i), argList.get(i+1), Integer.parseInt(argList.get(i+2)), argList.get(i+3), Integer.parseInt(argList.get(i+4)), 
												Double.parseDouble(argList.get(i+5)), argList.get(i+6), Double.parseDouble(argList.get(i+7)), argList.get(i+8));
			dbController.addMovie(tempMovie);
		}
		fstream.close();
	}

	/**
	 * Loads auditorium data from auditorium_data.txt file
	 * @throws IOException
	 */
	public void loadAuditoriums() throws IOException{
		FileInputStream fstream = new FileInputStream("data/auditorium_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String line;
		ArrayList<String> argList = new ArrayList<String>();
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		for(int i = 0; i < argList.size(); i+=2) {
			Auditorium a = new Auditorium(Integer.parseInt(argList.get(i)), Integer.parseInt(argList.get(i+1)));
			dbController.addAuditorium(a);
		}
		fstream.close();
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb
	}
	
	/**
	 * Loads theatre data from theatre_data.txt file
	 * @throws IOException
	 */
	public void loadTheatres() throws IOException {

<<<<<<< HEAD


	public void loadShowtimes() throws IOException{
		System.out.println("\n****LOADING SHOW TIMES****");

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
		System.out.println("\n****LOADING TICKETS****");

		b1 = new BankingInfo("Vaibhav Kapoor", "MASTER", "1111111111111111", "111", "01/22");
		b2 = new BankingInfo("William Kerr", "VISA", "2222222222222222", "222", "02/22");
		Payment p1 = new Payment(13.99, b1);
		Payment p2 = new Payment(15.99, b2);
		Ticket t1 = new Ticket(p1, s1.getMovie(), s1, s1.getSeats()[1][2]);
		Ticket t2 = new Ticket(p2, s2.getMovie(), s2, s2.getSeats()[3][3]);
		s1.bookSeat(1,2);
		s2.bookSeat(3,3);
=======
		FileInputStream fstream = new FileInputStream("data/theatre_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String line;
		ArrayList<String> argList = new ArrayList<String>();
		
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		
		for(int i = 0; i < argList.size(); i+=3) {
			ArrayList<Auditorium> a1 = dbController.getAuditoriumList();
			Theatre t = new Theatre(argList.get(i),1000+i, a1, argList.get(i+1), argList.get(i+2));
			dbController.addTheatre(t);
		}
		fstream.close();
	}

	/**
	 * Loads showtime data from showtime_date.txt and showtime_data.txt files
	 * @throws IOException
	 */
	public void loadShowtimes() throws IOException {
		
		ArrayList<Date> d = new ArrayList<Date>();
		FileInputStream fstream = new FileInputStream("data/showtime_date.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String line;
		ArrayList<String> argList = new ArrayList<String>();
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		for(int i = 0; i < argList.size(); i+=3) {
			Date setD = new Date(Integer.parseInt(argList.get(i)), Integer.parseInt(argList.get(i+1)), Integer.parseInt(argList.get(i+2)));
			d.add(setD);
		}
		argList.clear();
		fstream = new FileInputStream("data/showtime_data.txt");
		br = new BufferedReader(new InputStreamReader(fstream));
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		
		for(int i = 0; i < dbController.getMovieList().size() ; i++) {
			for(int j = 0; j < dbController.getAuditoriumList().size(); j++) {
				for(int k = 0; k < d.size(); k++) {
				Showtime s = new Showtime(d.get(k), dbController.getAuditoriumList().get(j), dbController.getMovieList().get(i), 
										Integer.parseInt(argList.get(2*k)), Integer.parseInt(argList.get(2*k+1)));
				dbController.addShowtime(s);
				}
			}
		}
		fstream.close();
	}

	/**
	 * Loads ticket data from payment_data.txt and ticket_data.txt files
	 * @throws IOException
	 */
	public void loadTickets() throws IOException {
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb

		ArrayList<Payment> pList = new ArrayList<Payment>();
		FileInputStream fstream = new FileInputStream("data/payment_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String line;
		ArrayList<String> argList = new ArrayList<String>();
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		fstream.close();
		for(int i = 0; i < argList.size(); i++) {
			Payment p = new Payment(Double.parseDouble(argList.get(i)), dbController.getInst().getBankAccounts().get(i));
			pList.add(p);
		}
		argList.clear();
		fstream = new FileInputStream("data/ticket_data.txt");
		br = new BufferedReader(new InputStreamReader(fstream));
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		for(int i = 0; i < pList.size(); i++) {
			Seat s = new Seat(Integer.parseInt(argList.get(2*i)),Integer.parseInt(argList.get(2*i+1)));
			Ticket t = new Ticket(pList.get(i), dbController.getMovieList().get(i), dbController.getShowtimeList().get(i), s);
			dbController.addTicket(t);
		}
	}
	
	/**
	 * Loads bank account data from banking_data.txt
	 * @throws IOException
	 */
	public void loadBankAccount() throws IOException{
		FileInputStream fstream = new FileInputStream("data/banking_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String line;
		ArrayList<String> argList = new ArrayList<String>();
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		fstream.close();
		for(int i = 0; i < argList.size(); i+=5) {
			BankingInfo b = new BankingInfo(argList.get(i), argList.get(i+1), argList.get(i+2), argList.get(i+3), argList.get(i+4));
			dbController.getInst().addAccount(b);
		}
	}

<<<<<<< HEAD
	public void loadUsers() throws IOException{
		System.out.println("\n****LOADING USERS****");

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
		System.out.println("\n****LOADING ANNOUNCEMENTS****");

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
		System.out.println("\n****LOADING BANKING INFO****");
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
=======
	/**
	 * Loads currently registered user information from registration_date.txt and registration_data.txt files
	 * @throws IOException
	 */
	public void loadUsers() throws IOException {

		ArrayList<Date> dList = new ArrayList<Date>();
		FileInputStream fstream = new FileInputStream("data/Registration_date.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String line;
		ArrayList<String> argList = new ArrayList<String>();
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		fstream.close();
		for(int i = 0; i < argList.size(); i+=3) {
			Date d = new Date(Integer.parseInt(argList.get(i)), Integer.parseInt(argList.get(i+1)), Integer.parseInt(argList.get(i+2)));
			dList.add(d);
		}
		argList.clear();
		
		fstream = new FileInputStream("data/registration_data.txt");
		br = new BufferedReader(new InputStreamReader(fstream));
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		fstream.close();
		int c = 0;
		for(int i = 0; i < argList.size(); i+=5) {
			RegisteredUser u = new RegisteredUser(argList.get(i), argList.get(i+1), argList.get(i+2), 
					argList.get(i+3), argList.get(i+4), dbController.getInst().getBankAccounts().get(c), dList.get(c));
			dbController.addUser(u);
			c++;
		}
	}

	/**
	 * Loads announcement information from announcement_date.txt and announcement_data.txt files
	 * @throws IOException
	 */
	public void loadAnnouncements() throws IOException {
		ArrayList<Date> dList = new ArrayList<Date>();
		ArrayList<Date> dList2 = new ArrayList<Date>();
		FileInputStream fstream = new FileInputStream("data/announcement_date.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String line;
		ArrayList <String> argList = new ArrayList<String>();
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		fstream.close();
		for(int i = 0; i < argList.size(); i+=6) {
			Date d = new Date(Integer.parseInt(argList.get(i)), Integer.parseInt(argList.get(i+1)), Integer.parseInt(argList.get(i+2)));
			dList.add(d);
			Date d2 = new Date(Integer.parseInt(argList.get(i+3)), Integer.parseInt(argList.get(i+4)), Integer.parseInt(argList.get(i+5)));
			dList2.add(d2);
		}
		argList.clear();
		fstream = new FileInputStream("data/announcement_data.txt");
		br = new BufferedReader(new InputStreamReader(fstream));
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		fstream.close();
		for(int i =0; i < argList.size(); i++) {
			Announcement a = new Announcement(dList.get(i), dList2.get(i), argList.get(i), dbController.getMovieList().get(i));
			dbController.addAnnouncement(a);
		}
		
>>>>>>> 1ea21d7878daeedbfd7d436f93d9e56a8138bceb
	}
	
	/**
	 * Loads existing voucher information from voucher_data.txt file
	 * @throws IOException
	 */
	public void loadVouchers() throws IOException {
		FileInputStream fstream = new FileInputStream("data/voucher_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String line;
		ArrayList <String> argList = new ArrayList<String>();
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		fstream.close();
		for(int i = 0; i < argList.size(); i++) {
			Voucher v= new Voucher(Double.parseDouble(argList.get(i)));
			dbController.addVoucher(v);
		}
	}
}
