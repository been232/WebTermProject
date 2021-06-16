package domain;

import java.time.LocalDateTime;

public class RentalManagement {

    public int rentalNum;
    public int bookNum;
    public String bookId;
    public String bookName;
    public int userNum;
    public LocalDateTime rentalDate;
    public LocalDateTime returndate;

    public RentalManagement(){

    }

    public RentalManagement(int rentalNum, int bookNum, String bookId, String bookName, int userNum, LocalDateTime rentalDate, LocalDateTime returndate) {
        this.rentalNum = rentalNum;
        this.bookNum = bookNum;
        this.bookId = bookId;
        this.bookName = bookName;
        this.userNum = userNum;
        this.rentalDate = rentalDate;
        this.returndate = returndate;
    }

    public int getRentalNum() {
        return rentalNum;
    }

    public void setRentalNum(int rentalNum) {
        this.rentalNum = rentalNum;
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDateTime getReturndate() {
        return returndate;
    }

    public void setReturndate(LocalDateTime returndate) {
        this.returndate = returndate;
    }

}
