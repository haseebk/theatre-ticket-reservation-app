package database;

import domain.model.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DatabasePopulator{
	DataController dbController;
	

	public DatabasePopulator() {
		dbController = DataController.getOnlyInstance();
	}

	public void loadDatabase() throws IOException{
		loadMovies();
		loadTheatres();
		loadAnnouncements();
		loadTickets();
		loadInst();
		loadBankInfo();
		loadPayment();
		loadUsers();
		loadVouchers();
	}

<<<<<<< HEAD
	public void loadInst() throws IOException{
		FileInputStream fstream = new FileInputStream("data/institution_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[1];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			dbController.setInst(new FinancialInstitution(argList[0]));
		}
		fstream.close();
=======
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
>>>>>>> devel
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
	}



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
	}

<<<<<<< HEAD
	public void loadTickets() throws IOException{
		FileInputStream fstream = new FileInputStream("data/ticket_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[11];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			Showtime foundShowtime = dbController.searchShowtimeInfo(Integer.parseInt(argList[3]));
			Seat bookedSeat = new Seat(Integer.parseInt(argList[4]),Integer.parseInt(argList[5]),0);
			foundShowtime.bookSeat(bookedSeat.getRow(),bookedSeat.getSeatNum());
					dbController.addTicket(new Ticket(Integer.parseInt(argList[0]),dbController.searchPaymentInfo(Integer.parseInt(argList[1])),
					dbController.searchMovie(Integer.parseInt(argList[2])),foundShowtime, bookedSeat));
		}
		fstream.close();
=======
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

		dbController.addTicket(t1);
		dbController.addTicket(t2);
>>>>>>> devel
	}

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
			BankingInfo temp = new BankingInfo(Integer.parseInt(argList[0]), argList[1], argList[2], argList[3], argList[4], argList[5]);
			dbController.addBankingInfo(temp);
			dbController.getInst().addAccount(temp);
		}
	}

	public void loadPayment() throws IOException{
		FileInputStream fstream = new FileInputStream("data/payment_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[8];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
			}
			dbController.addPayment(new Payment(Integer.parseInt(argList[0]), Double.parseDouble(argList[1]), dbController.searchBankingInfo(Integer.parseInt(argList[2]))));
		}
	}

	public void loadVouchers() throws IOException {
		FileInputStream fstream = new FileInputStream("data/voucher_data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		String[] argList = new String[2];

		while((line = br.readLine()) != null) {
			argList = line.split(":");
			for(int i = 0; i < argList.length; i++){
				System.out.println(argList[i]);
			}
			boolean use = false;
			if(argList[2].compareTo("true") == 0)
				use = true;
			dbController.addVoucher(new Voucher(Integer.parseInt(argList[0]), Double.parseDouble(argList[1]), use));
		}
		fstream.close();
		loadAuditoriums();
	}
}
