package database;

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
        writeUser();
        writeBankingInfo();
        writePayment();
        writeVoucher();
    }

    public void writeUser() throws IOException {
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/registered_user_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getUserList().size(); i++){
            bw.write(dbController.getUserList().get(i).getUserID() + ":" + dbController.getUserList().get(i).getUsername() + ":" +
                    dbController.getUserList().get(i).getPassword() + ":" + dbController.getUserList().get(i).getF_name() + ":" +
                    dbController.getUserList().get(i).getL_name() + ":" + dbController.getUserList().get(i).getEmail() + ":" +
                    dbController.getUserList().get(i).getBankInfo().getBankID() + ":" + dbController.getUserList().get(i).getAdminFeeDate().getDay() + ":" +
                    dbController.getUserList().get(i).getAdminFeeDate().getMonth() + ":" + dbController.getUserList().get(i).getAdminFeeDate().getYear() + "\n");
        }
        bw.close();
    }

    public void writeBankingInfo() throws IOException {
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/banking_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getBankList().size(); i++) {
            bw.write(dbController.getBankList().get(i).getBankID() + ":" + dbController.getBankList().get(i).getCustomerName() + ":" +
                    dbController.getBankList().get(i).getCardType() + ":" + dbController.getBankList().get(i).getCardNumber() + ":" +
                    dbController.getBankList().get(i).getCardSVS() + ":" + dbController.getBankList().get(i).getCardExpirationDate()+"\n");
        }
        bw.close();
    }

    public void writePayment() throws IOException {
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/payment_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getBankList().size(); i++) {
            bw.write(dbController.getPaymentList().get(i).getPaymentID() + ":" + dbController.getPaymentList().get(i).getAmount() + ":" +
                    dbController.getPaymentList().get(i).getCard().getBankID() + "\n");
        }
        bw.close();
    }

    public void writeVoucher() throws IOException{
        OutputStreamWriter Ostream = new OutputStreamWriter(new FileOutputStream("data/voucher_data.txt"), "UTF-8");
        BufferedWriter bw = new BufferedWriter(Ostream);
        for(int i = 0; i < dbController.getVoucherList().size(); i++) {
            bw.write(dbController.getVoucherList().get(i).getVoucherCode()+":"+ dbController.getVoucherList().get(i).getAmount() +":"+ dbController.getVoucherList().get(i).isUsed()+"\n");
        }
        bw.close();
    }
}
