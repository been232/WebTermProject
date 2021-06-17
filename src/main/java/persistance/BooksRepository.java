package persistance;

import domain.Books;
import domain.BooksManagement;
import domain.RentalManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
    public ArrayList<Books> look(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<Books> bookList = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try{
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int num = rs.getInt("Book_Num");
                String id = rs.getString("Book_Id");
                String name = rs.getString("Book_Name");
                String writer = rs.getString("Book_Writer");
                String publisher = rs.getString("Book_Publisher");
                LocalDateTime registration = rs.getTimestamp("Book_registration").toLocalDateTime();
                Books book = new Books(num, id, name, writer, publisher, registration);
                bookList.add(book);
            }

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
        return bookList;
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
    public Books findByNum(int num){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM BOOKS WHERE book_num=?";
        Books books = new Books();
        try{
            conn = ds.getConnection();
            pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,num);
            rs = pstmt.executeQuery();
            while(rs.next()){
                books.setNum(rs.getInt("book_num"));
                books.setId(rs.getString("book_id"));
                books.setName(rs.getString("book_name"));
                books.setWriter(rs.getString("book_writer"));
                books.setPublisher(rs.getString("book_publisher"));
                books.setRegistraion(rs.getTimestamp("book_registration").toLocalDateTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                pstmt.close();
                rs.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    public ArrayList<Books> findAll(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from books";
        ArrayList<Books> books = new ArrayList<Books>();
        try{
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                int num = rs.getInt("Book_num");
                String id = rs.getString("Book_id");
                String name = rs.getString("Book_name");
                String writer = rs.getString("Book_Writer");
                String publisher = rs.getString("Book_publisher");
                LocalDateTime registration = rs.getTimestamp("Book_registration").toLocalDateTime();
                Books posts = new Books(num,id,name,writer,publisher,registration);
                books.add(posts);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }
    public void deleteByNum(int num){
        Connection conn = null;
        PreparedStatement pstmt =null;

        String sql = "delete from books where Book_num=?";
        try{
            conn=ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,num);
            int n = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                pstmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();;
            }
        }
    }
}
