package database;

import domain.model.*;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DatabaseWriter {
    DataController dbController;

    public DatabaseWriter() {
        dbController = DataController.getOnlyInstance();
    }

    public void writeDatabase() throws IOException {
        writeAnnouncement();
        writeAuditorium();
        writeBankingInfo();
        writeInstitution();
        writeMovie();
        writePayment();
        writeReceipt();
        writeRegisteredUser();
        writeShowtime();
        writeTheatre();
        writeTicket();
        writeVoucher();
    }

    public void writeAnnouncement() throws IOException{
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/announcement_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getAnnouncementList().size(); i++) {
            Announcement a = dbController.getAnnouncementList().get(i);
            bw.write(a.getAnnouncementID() + ":" + a.getPrivateAnnounceDate().getDay() + ":" + a.getPrivateAnnounceDate().getMonth() + ":" +
                    a.getPrivateAnnounceDate().getYear() + ":" + a.getPublicAnnounceDate().getDay() + ":" + a.getPublicAnnounceDate().getMonth() + ":" +
                    a.getPublicAnnounceDate().getYear() + ":" + a.getMovieAnnouncement().getMovieID() + "\n");
        }
        bw.close();
    }

    public void writeAuditorium() throws IOException{
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/auditorium_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getAuditoriumList().size(); i++) {
            Auditorium a = dbController.getAuditoriumList().get(i);
            bw.write(a.getAuditoriumID() + ":" + a.getNum_of_rows() + ":" + a.getNum_of_cols() + ":" + a.getTheatre().getTheatreID() + "\n");
        }
        bw.close();
    }

    public void writeBankingInfo() throws IOException {
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/banking_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getBankList().size(); i++) {
            BankingInfo b = dbController.getBankList().get(i);
            bw.write(b.getBankID() + ":" + b.getCustomerName() + ":" + b.getCardType() + ":" + b.getCardNumber() + ":" +
                    b.getCardSVS() + ":" + b.getCardExpirationDate()+"\n");
        }
        bw.close();
    }

    public void writeInstitution() throws IOException{
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/institution_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        bw.write(dbController.getInst().getName());
        bw.close();
    }

    public void writeMovie() throws IOException{
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/movie_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getMovieList().size(); i++) {
            Movie m = dbController.getMovieList().get(i);
            bw.write(m.getMovieID() + ":" + m.getTitle() + ":" + m.getGenre() + ":" + m.getYear() + ":" + m.getDirector()
                    + ":" + m.getMovieLength() + ":" + m.getRating() + ":" + m.getPoster() + ":" + m.getPrice() + ":" + m.getSynopsis() + "\n");
        }
        bw.close();
    }

    public void writePayment() throws IOException {
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/payment_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getPaymentList().size(); i++) {
            Payment p = dbController.getPaymentList().get(i);
            bw.write(p.getPaymentID() + ":" + p.getAmount() + ":" + p.getCard().getBankID() + "\n");
        }
        bw.close();
    }

    public void writeReceipt() throws IOException{
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/receipt_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getReceiptList().size(); i++) {
            Receipt r = dbController.getReceiptList().get(i);
            bw.write(r.getReceiptID() + ":" + r.getPayment().getPaymentID() + ":" + r.getDate().getDay() + ":"
                    + r.getDate().getMonth() + ":" + r.getDate().getYear()+ "\n");
        }
        bw.close();
    }

    public void writeRegisteredUser() throws IOException {
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/registered_user_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getUserList().size(); i++){
            RegisteredUser r = dbController.getUserList().get(i);
            bw.write(r.getUserID() + ":" + r.getUsername() + ":" + r.getPassword() + ":" + r.getF_name() + ":" +
                    r.getL_name() + ":" + r.getEmail() + ":" + r.getBankInfo().getBankID() + ":" + r.getAdminFeeDate().getDay() + ":" +
                    r.getAdminFeeDate().getMonth() + ":" + r.getAdminFeeDate().getYear() + "\n");
        }
        bw.close();
    }

    public void writeShowtime() throws IOException{
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/showtime_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getShowtimeList().size(); i++) {
            Showtime s = dbController.getShowtimeList().get(i);
            bw.write(s.getShowtimeID() + ":"+ s.getMovie().getMovieID() + ":"+ s.getAuditorium().getAuditoriumID() + ":" +
                    s.getShowDate().getDay() + ":"+ s.getShowDate().getMonth() + ":"+ s.getShowDate().getYear() + ":" +
                    s.getHour() + ":"+ s.getMinutes() +"\n");
        }
        bw.close();
    }

    public void writeTheatre() throws IOException{
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/theatre_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getTheatreList().size(); i++) {
            Theatre t = dbController.getTheatreList().get(i);
            bw.write(t.getTheatreID() + ":"+ t.getT_name() + ":"+ t.getPhoneNumber() + ":" +
                    t.getAddress() +"\n");
        }
        bw.close();
    }

    public void writeTicket() throws IOException{
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/ticket_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getTicketList().size(); i++) {
            Ticket t = dbController.getTicketList().get(i);
            bw.write(t.getTicketID() + ":"+ t.getPayment().getPaymentID() + ":"+ t.getThe_movie().getMovieID() + ":" +
                    t.getShowtime().getShowtimeID() + ":" + t.getSeat().getRow() + ":"+ t.getSeat().getSeatNum() +
                    ":"+ t.getReceipt().getReceiptID() +"\n");
        }
        bw.close();
    }

    public void writeVoucher() throws IOException{
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/voucher_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getVoucherList().size(); i++) {
            Voucher v = dbController.getVoucherList().get(i);
            bw.write(v.getVoucherCode() + ":"+ v.getAmount() + ":"+ v.isUsed()+"\n");
        }
        bw.close();
    }

}
