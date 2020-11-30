package domain.model;

public class Date {
    public int day;
    public String month;
    public int year;

    public Date(int d, String m, int y){
        day = d;
        month = m;
        year = y;
    }

    public String getDate(){
        return (month + " " + day + ", " + year);
    }

    public void setDate(int d, String m, int y){
        day = d;
        month = m;
        year = y;
    }

}
