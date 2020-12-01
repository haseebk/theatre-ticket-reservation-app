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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import domain.model.Ticket;
import domain.model.Announcement;
import domain.model.Payment;
import domain.model.Voucher;

public class DatabasePopulator {
	DataController dbController;
	/*private Movie spiderverse;
	private Movie getout;
	private Movie hereditary;
	private Movie paddington;
	private Showtime s1;
	private Showtime s2;
	private FinancialInstitution inst;*/

	public DatabasePopulator() {
		dbController = DataController.getOnlyInstance();
	}

	public void loadDatabase() throws IOException{
		loadMovies();
		loadTheatres();
		loadShowtimes();
		loadAnnouncements();
		loadBankAccount();
		loadUsers(); 
		loadTickets();
		loadVouchers();
	}

	public void loadMovies() throws IOException {
		
		FileInputStream fstream = new FileInputStream("data/movie_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String line;
		ArrayList<String> argList = new ArrayList<String>();
		
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		fstream.close();
		
		for(int i = 0; i < argList.size(); i+=9) {
			Movie tempMovie = new Movie(argList.get(i), argList.get(i+1), Integer.parseInt(argList.get(i+2)), argList.get(i+3), Integer.parseInt(argList.get(i+4)), 
												Double.parseDouble(argList.get(i+5)), argList.get(i+6), Double.parseDouble(argList.get(i+7)), argList.get(i+8));
			dbController.addMovie(tempMovie);
		}
		
	}

	public void loadTheatres() throws IOException {

		FileInputStream fstream = new FileInputStream("data/auditorium_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String line;
		ArrayList<String> argList = new ArrayList<String>();
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		fstream.close();
		for(int i = 0; i < argList.size(); i+=2) {
			Auditorium a = new Auditorium(Integer.parseInt(argList.get(i)), Integer.parseInt(argList.get(i+1)));
			dbController.addAuditorium(a);
		}
		argList.clear();
		
		fstream = new FileInputStream("data/theatre_data.txt");
		br = new BufferedReader(new InputStreamReader(fstream));
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		fstream.close();
		for(int i = 0; i < argList.size(); i+=3) {
			ArrayList<Auditorium> a1 = dbController.getAuditoriumList();
			Theatre t = new Theatre(argList.get(i),1000+i, a1, argList.get(i+1), argList.get(i+2));
			dbController.addTheatre(t);
		}
	}

	public void loadShowtimes() throws IOException {
		
		ArrayList<Date> d = new ArrayList<Date>();
		FileInputStream fstream = new FileInputStream("data/showtime_date.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String line;
		ArrayList<String> argList = new ArrayList<String>();
		while((line = br.readLine()) != null) {
			argList.add(line);
		}
		fstream.close();
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
		fstream.close();
		
		for(int i = 0; i < dbController.getMovieList().size() ; i++) {
			for(int j = 0; j < dbController.getAuditoriumList().size(); j++) {
				for(int k = 0; k < d.size(); k++) {
				Showtime s = new Showtime(d.get(k), dbController.getAuditoriumList().get(j), dbController.getMovieList().get(i), 
										Integer.parseInt(argList.get(2*k)), Integer.parseInt(argList.get(2*k+1)));
				dbController.addShowtime(s);
				}
			}
		}
	}

	public void loadTickets() throws IOException {

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
		for(int i = 0; i < argList.size(); i+=3) {
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
		
	}
	
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
