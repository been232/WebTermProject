package domain;

public class RentalManagement {
    public int num;
    public int bookNum;
    public String bookId;
    public String userNum;
    public String date;
    public String returndate;

    public RentalManagement(){

    }

    public RentalManagement(int num, int bookNum, String bookId, String userNum, String date, String returndate) {
        this.num = num;
        this.bookNum = bookNum;
        this.bookId = bookId;
        this.userNum = userNum;
        this.date = date;
        this.returndate = returndate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    @Override
    public String toString() {
        return "RentalManagement{" +
                "num=" + num +
                ", bookNum=" + bookNum +
                ", bookId='" + bookId + '\'' +
                ", userNum='" + userNum + '\'' +
                ", date='" + date + '\'' +
                ", returndate='" + returndate + '\'' +
                '}';
    }
}
