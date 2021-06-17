package persistance;

import domain.Books;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BooksRepository {
    private static BooksRepository instance;
    private static DataSource ds;
    private BooksRepository(){

    }
    public static BooksRepository getInstance() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/MySql");
                return instance = new BooksRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    }
    public void save(Books books){
        String sql = "insert into books(Book_Id, Book_Name,Book_Writer,Book_Publisher,Book_registration ) values(?,?,?,?,?);";

        Connection conn =null;
        PreparedStatement pstmt = null;
        try{
            conn = ds.getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,books.getId());
            pstmt.setString(2,books.getName());
            pstmt.setString(3,books.getWriter());
            pstmt.setString(4,books.getPublisher());
            pstmt.setString(5,books.getRegistraion().toString());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                pstmt.close();
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
