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
}
