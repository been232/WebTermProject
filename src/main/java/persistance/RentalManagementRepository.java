package persistance;

import domain.RentalManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RentalManagementRepository {
    private static RentalManagementRepository instance;
    private static DataSource ds;
    private RentalManagementRepository() {

    }
    public static RentalManagementRepository getInstance() {
        if(instance == null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/MySql");
                return instance = new RentalManagementRepository();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public ArrayList<RentalManagement> findRentals(int userNum) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        RentalManagement rental = null;
        ArrayList<RentalManagement> rentals = new ArrayList<>();
        String sql = "SELECT * FROM rentalmanagement WHERE User_Num = ?";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNum);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int num = rs.getInt("Rental_Num");
                int bookNum = rs.getInt("Book_Num");
                String bookId = rs.getString("Book_Id");
                String bookName = rs.getString("Book_Name");
                userNum = rs.getInt("User_Num");
                LocalDateTime date = rs.getTimestamp("Rental_Date").toLocalDateTime();
                LocalDateTime returnDate = rs.getTimestamp("Rental_Return").toLocalDateTime();
                rental = new RentalManagement(num, bookNum, bookId, bookName, date, returnDate);
                rentals.add(rental);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rentals;
    }
}
