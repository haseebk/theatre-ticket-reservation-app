package database;

import domain.model.*;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

<<<<<<< HEAD
public class DatabasePopulator {
	/**
	 * Populates the data from text files
	 * 
	 * @author Eddie
	 *
	 */
		DataController dbController;

		public DatabasePopulator() {
			dbController = DataController.getOnlyInstance();
		}

		/**
		 * Constructor to load all the different data fields
		 * 
		 * @throws IOException
		 */
		public void loadDatabase() throws IOException {
			loadMovies();
			loadAuditoriums();
			loadTheatres();
			loadAnnouncements();
			loadShowtimes();
			loadBankAccount();
			loadUsers();
			loadTickets();
			loadInst();
			loadBankInfo();
			loadPayment();
			loadVouchers();
		}
=======
public class DatabasePopulator{
	DataController dbController;
	

	public DatabasePopulator() {
		dbController = DataController.getOnlyInstance();
	}

	public void loadDatabase() throws IOException{
		loadMovies();
		loadTheatres();
		loadAnnouncements();
		loadInst();
		loadBankInfo();
		loadPayment();
		loadReceipts();
		loadTickets();
		loadUsers();
		loadVouchers();
	}

	public void loadInst() throws IOException{
		FileInputStream fstream = new FileInputStream("data/institution_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[1];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			if(argList[0].compareTo("") == 0){
				break;
			}
			dbController.setInst(new FinancialInstitution(argList[0]));
		}
		fstream.close();
	}
	
	public void loadMovies() throws IOException {
		System.out.println("\n****LOADING MOVIES****");
>>>>>>> experimental-w

		public void loadInst() throws IOException {
			FileInputStream fstream = new FileInputStream("data/institution_data.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String line;
			String[] argList = new String[1];

<<<<<<< HEAD
			while ((line = br.readLine()) != null) {
				argList = line.split(":");
				dbController.setInst(new FinancialInstitution(argList[0]));
			}
			fstream.close();
=======
		while((line = br.readLine()) != null) {
			argList = line.split(":");
			if(argList[0].compareTo("") == 0){
				break;
			}
			System.out.println(argList[5]);
			dbController.addMovie(new Movie(Integer.parseInt(argList[0]),argList[1],argList[2],Integer.parseInt(argList[3]),
					argList[4],Double.parseDouble(argList[5]),Double.parseDouble(argList[6]),argList[7],Double.parseDouble(argList[8]),argList[9]));
>>>>>>> experimental-w
		}



	

<<<<<<< HEAD
	
=======
		while((line = br.readLine()) != null) {
			argList = line.split(":");
			if(argList[0].compareTo("") == 0){
				break;
			}
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
			}
			dbController.addTheatre(new Theatre(Integer.parseInt(argList[0]), argList[1], argList[2], argList[3]));
		}
		fstream.close();
		loadAuditoriums();
	}
>>>>>>> experimental-w

		/**
		 * Loads movie data from movie_data.txt file
		 * 
		 * @throws IOException
		 */
		public void loadMovies() throws IOException {

			FileInputStream fstream = new FileInputStream("data/movie_data.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String line;
			ArrayList<String> argList = new ArrayList<String>();

			while ((line = br.readLine()) != null) {
				argList.add(line);
			}

<<<<<<< HEAD
			for (int i = 0; i < argList.size(); i += 9) {
				Movie tempMovie = new Movie(argList.get(i), argList.get(i + 1), Integer.parseInt(argList.get(i + 2)),
						argList.get(i + 3), Integer.parseInt(argList.get(i + 4)),
						Double.parseDouble(argList.get(i + 5)), argList.get(i + 6),
						Double.parseDouble(argList.get(i + 7)), argList.get(i + 8));
				dbController.addMovie(tempMovie);
=======
		while((line = br.readLine()) != null) {
			argList = line.split(":");
			if(argList[0].compareTo("") == 0){
				break;
			}
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
>>>>>>> experimental-w
			}
			fstream.close();
		}
<<<<<<< HEAD

		/**
		 * Loads auditorium data from auditorium_data.txt file
		 * 
		 * @throws IOException
		 */
		public void loadAuditoriums() throws IOException {
			FileInputStream fstream = new FileInputStream("data/auditorium_data.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String line;
			ArrayList<String> argList = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				argList.add(line);
			}
			for (int i = 0; i < argList.size(); i += 2) {
				Auditorium a = new Auditorium(Integer.parseInt(argList.get(i)), Integer.parseInt(argList.get(i + 1)));
				dbController.addAuditorium(a);
			}
			fstream.close();
		}
=======
		fstream.close();
		loadShowtimes();
	}
>>>>>>> experimental-w

		/**
		 * Loads theatre data from theatre_data.txt file
		 * 
		 * @throws IOException
		 */
		public void loadTheatres() throws IOException {
		}

		

		

		/**
		 * Loads showtime data from showtime_date.txt and showtime_data.txt files
		 * 
		 * @throws IOException
		 */
		public void loadShowtimes() throws IOException {

			ArrayList<Date> d = new ArrayList<Date>();
			FileInputStream fstream = new FileInputStream("data/showtime_date.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

<<<<<<< HEAD
			String line;
			ArrayList<String> argList = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				argList.add(line);
			}
			for (int i = 0; i < argList.size(); i += 3) {
				Date setD = new Date(Integer.parseInt(argList.get(i)), Integer.parseInt(argList.get(i + 1)),
						Integer.parseInt(argList.get(i + 2)));
				d.add(setD);
			}
			argList.clear();
			fstream = new FileInputStream("data/showtime_data.txt");
			br = new BufferedReader(new InputStreamReader(fstream));
			while ((line = br.readLine()) != null) {
				argList.add(line);
=======
		while((line = br.readLine()) != null) {
			argList = line.split(":");
			if(argList[0].compareTo("") == 0){
				break;
			}
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
>>>>>>> experimental-w
			}

			for (int i = 0; i < dbController.getMovieList().size(); i++) {
				for (int j = 0; j < dbController.getAuditoriumList().size(); j++) {
					for (int k = 0; k < d.size(); k++) {
						Showtime s = new Showtime(d.get(k), dbController.getAuditoriumList().get(j),
								dbController.getMovieList().get(i), Integer.parseInt(argList.get(2 * k)),
								Integer.parseInt(argList.get(2 * k + 1)));
						dbController.addShowtime(s);
					}
				}
			}
			fstream.close();
		}

<<<<<<< HEAD
		/**
		 * Loads ticket data from payment_data.txt and ticket_data.txt files
		 * 
		 * @throws IOException
		 */
		public void loadTickets() throws IOException {

			ArrayList<Payment> pList = new ArrayList<Payment>();
			FileInputStream fstream = new FileInputStream("data/payment_data.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String line;
			ArrayList<String> argList = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				argList.add(line);
			}
			fstream.close();
			for (int i = 0; i < argList.size(); i++) {
				Payment p = new Payment(Double.parseDouble(argList.get(i)),
						dbController.getInst().getBankAccounts().get(i));
				pList.add(p);
			}
			argList.clear();
			fstream = new FileInputStream("data/ticket_data.txt");
			br = new BufferedReader(new InputStreamReader(fstream));
			while ((line = br.readLine()) != null) {
				argList.add(line);
			}
			for (int i = 0; i < pList.size(); i++) {
				Seat s = new Seat(Integer.parseInt(argList.get(2 * i)), Integer.parseInt(argList.get(2 * i + 1)));
				Ticket t = new Ticket(pList.get(i), dbController.getMovieList().get(i),
						dbController.getShowtimeList().get(i), s);
				dbController.addTicket(t);
			}
		}

		/**
		 * Loads bank account data from banking_data.txt
		 * 
		 * @throws IOException
		 */
		public void loadBankAccount() throws IOException {
			FileInputStream fstream = new FileInputStream("data/banking_data.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String line;
			ArrayList<String> argList = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				argList.add(line);
=======

	public void loadTickets() throws IOException {
		FileInputStream fstream = new FileInputStream("data/ticket_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[4];

		while ((line = br.readLine()) != null) {
			argList = line.split(":");
			if(argList[0].compareTo("") == 0){
				break;
			}
			Showtime foundShowtime = dbController.searchShowtimeInfo(Integer.parseInt(argList[3]));
			Seat bookedSeat = new Seat(Integer.parseInt(argList[4]), Integer.parseInt(argList[5]), 0);
			foundShowtime.bookSeat(bookedSeat.getRow(), bookedSeat.getSeatNum());
			dbController.addTicket(new Ticket(Integer.parseInt(argList[0]), dbController.searchPaymentInfo(Integer.parseInt(argList[1])),
					dbController.searchMovie(Integer.parseInt(argList[2])), foundShowtime, bookedSeat,dbController.searchReceipt(Integer.parseInt(argList[6]))));
		}
		fstream.close();
	}


	public void loadUsers() throws IOException{
		System.out.println("\n****LOADING USERS****");

		FileInputStream fstream = new FileInputStream("data/registered_user_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[10];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			if(argList[0].compareTo("") == 0){
				break;
			}
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
>>>>>>> experimental-w
			}
			fstream.close();
			for (int i = 0; i < argList.size(); i += 5) {
				BankingInfo b = new BankingInfo(argList.get(i), argList.get(i + 1), argList.get(i + 2),
						argList.get(i + 3), argList.get(i + 4));
				dbController.getInst().addAccount(b);
			}
		}

		public void loadTickets() throws IOException {
			FileInputStream fstream = new FileInputStream("data/ticket_data.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String line;
			String[] argList = new String[11];

			while ((line = br.readLine()) != null) {
				argList = line.split(":");
				Showtime foundShowtime = dbController.searchShowtimeInfo(Integer.parseInt(argList[3]));
				Seat bookedSeat = new Seat(Integer.parseInt(argList[4]), Integer.parseInt(argList[5]), 0);
				foundShowtime.bookSeat(bookedSeat.getRow(), bookedSeat.getSeatNum());
				dbController.addTicket(new Ticket(Integer.parseInt(argList[0]),
						dbController.searchPaymentInfo(Integer.parseInt(argList[1])),
						dbController.searchMovie(Integer.parseInt(argList[2])), foundShowtime, bookedSeat));
			}
			fstream.close();
		}

		

		

		

<<<<<<< HEAD
		/**
		 * Loads currently registered user information from registration_date.txt and
		 * registration_data.txt files
		 * 
		 * @throws IOException
		 */
		public void loadUsers() throws IOException {
=======
		while((line = br.readLine()) != null) {
			argList = line.split(":");
			if(argList[0].compareTo("") == 0){
				break;
			}
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
>>>>>>> experimental-w

			ArrayList<Date> dList = new ArrayList<Date>();
			FileInputStream fstream = new FileInputStream("data/Registration_date.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String line;
			ArrayList<String> argList = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				argList.add(line);
			}
			fstream.close();
			for (int i = 0; i < argList.size(); i += 3) {
				Date d = new Date(Integer.parseInt(argList.get(i)), Integer.parseInt(argList.get(i + 1)),
						Integer.parseInt(argList.get(i + 2)));
				dList.add(d);
			}
			argList.clear();

			fstream = new FileInputStream("data/registration_data.txt");
			br = new BufferedReader(new InputStreamReader(fstream));
			while ((line = br.readLine()) != null) {
				argList.add(line);
			}
			fstream.close();
			int c = 0;
			for (int i = 0; i < argList.size(); i += 5) {
				RegisteredUser u = new RegisteredUser(argList.get(i), argList.get(i + 1), argList.get(i + 2),
						argList.get(i + 3), argList.get(i + 4), dbController.getInst().getBankAccounts().get(c),
						dList.get(c));
				dbController.addUser(u);
				c++;
			}
		}

<<<<<<< HEAD
		/**
		 * Loads announcement information from announcement_date.txt and
		 * announcement_data.txt files
		 * 
		 * @throws IOException
		 */
		public void loadAnnouncements() throws IOException {
			ArrayList<Date> dList = new ArrayList<Date>();
			ArrayList<Date> dList2 = new ArrayList<Date>();
			FileInputStream fstream = new FileInputStream("data/announcement_date.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String line;
			ArrayList<String> argList = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				argList.add(line);
			}
			fstream.close();
			for (int i = 0; i < argList.size(); i += 6) {
				Date d = new Date(Integer.parseInt(argList.get(i)), Integer.parseInt(argList.get(i + 1)),
						Integer.parseInt(argList.get(i + 2)));
				dList.add(d);
				Date d2 = new Date(Integer.parseInt(argList.get(i + 3)), Integer.parseInt(argList.get(i + 4)),
						Integer.parseInt(argList.get(i + 5)));
				dList2.add(d2);
			}
			argList.clear();
			fstream = new FileInputStream("data/announcement_data.txt");
			br = new BufferedReader(new InputStreamReader(fstream));
			while ((line = br.readLine()) != null) {
				argList.add(line);
			}
			fstream.close();
			for (int i = 0; i < argList.size(); i++) {
				Announcement a = new Announcement(dList.get(i), dList2.get(i), argList.get(i),
						dbController.getMovieList().get(i));
				dbController.addAnnouncement(a);
=======
		while((line = br.readLine()) != null) {
			argList = line.split(":");
			if(argList[0].compareTo("") == 0){
				break;
			}
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
>>>>>>> experimental-w
			}
		}



<<<<<<< HEAD
		public void loadPayment() throws IOException {
			FileInputStream fstream = new FileInputStream("data/payment_data.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
=======
		while((line = br.readLine()) != null) {
			argList = line.split(":");
			if(argList[0].compareTo("") == 0){
				break;
			}
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
			}
			dbController.addPayment(new Payment(Integer.parseInt(argList[0]), Double.parseDouble(argList[1]), dbController.searchBankingInfo(Integer.parseInt(argList[2]))));
		}
	}
>>>>>>> experimental-w

			String line;
			String[] argList = new String[8];

			while ((line = br.readLine()) != null) {
				argList = line.split(":");
				for (int i = 0; i < argList.length; i++) {
					System.out.println(argList[i]);
				}
				dbController.addPayment(new Payment(Integer.parseInt(argList[0]), Double.parseDouble(argList[1]),
						dbController.searchBankingInfo(Integer.parseInt(argList[2]))));
			}
		}

<<<<<<< HEAD
		public void loadVouchers() throws IOException {
			FileInputStream fstream = new FileInputStream("data/voucher_data.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String line;
			String[] argList = new String[2];

			while ((line = br.readLine()) != null) {
				argList = line.split(":");
				for (int i = 0; i < argList.length; i++) {
					System.out.println(argList[i]);
				}
				boolean use = false;
				if (argList[2].compareTo("true") == 0)
					use = true;
				dbController.addVoucher(new Voucher(Integer.parseInt(argList[0]), Double.parseDouble(argList[1]), use));
=======
		while((line = br.readLine()) != null) {
			argList = line.split(":");
			if(argList[0].compareTo("") == 0){
				break;
			}
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
>>>>>>> experimental-w
			}
			fstream.close();
			loadAuditoriums();
		}
<<<<<<< HEAD
=======
		fstream.close();
	}

	public void loadReceipts() throws IOException {
		FileInputStream fstream = new FileInputStream("data/receipt_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[2];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			if(argList[0].compareTo("") == 0){
				break;
			}
			Date foundDate = new Date(Integer.parseInt(argList[2]),Integer.parseInt(argList[3]),Integer.parseInt(argList[4]));
			dbController.addReceipt(new Receipt(Integer.parseInt(argList[0]),dbController.searchPaymentInfo(Integer.parseInt(argList[1])),foundDate));
		}
		fstream.close();
>>>>>>> experimental-w
	}
}
