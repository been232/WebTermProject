package persistance;

import domain.Books;
import domain.BooksManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BooksManagerRepository {
    private static BooksManagerRepository instance;
    private static DataSource ds;

    public BooksManagerRepository() {
    }
    public static BooksManagerRepository getInstance() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/MySql");
                return instance = new BooksManagerRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    } public void save(BooksManagement booksManagement){
        String sql1 = "insert into booksmanagement(Book_Id,Book_Place,Book_Cnt) values(?,?,?);";
        String sql2 = "update booksmanagement set Book_Cnt=? where Book_Id=? ";

        Connection conn =null;
        PreparedStatement pstmt = null;
        BooksManagement check = findById(booksManagement.getId());
        System.out.println(check.getId());
        System.out.println(booksManagement.getId());
        try{
            conn = ds.getConnection();
            if(check.getId() == null){
                pstmt = conn.prepareStatement(sql1);
                pstmt.setString(1,booksManagement.getId());
                pstmt.setString(2,booksManagement.getPlace());
                pstmt.setInt(3,1);

                pstmt.executeUpdate();
            }
            else if(check.getId() != null){
                pstmt = conn.prepareStatement(sql2);
                pstmt.setInt(1,check.getCnt()+1);
                pstmt.setString(2,booksManagement.getId());

                pstmt.executeUpdate();
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
    }
    public BooksManagement findById(String id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM BOOKSMANAGEMENT WHERE book_id=?";
        BooksManagement booksManagement = new BooksManagement();
        try{
            conn = ds.getConnection();
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rs = pstmt.executeQuery();
            while(rs.next()){
                booksManagement.setId(rs.getString("book_id"));
                booksManagement.setPlace(rs.getString("book_place"));
                booksManagement.setCnt(rs.getInt("book_cnt"));
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
        return booksManagement;
    }

    public ArrayList<BooksManagement> findAll(){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM booksmanagement";
        ArrayList<BooksManagement> booksManagements = new ArrayList<>();

        try{
            conn = ds.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()){
                String id = rs.getString("Book_id");
                String place = rs.getString("Book_place");
                int cnt = rs.getInt("Book_cnt");
                BooksManagement posts = new BooksManagement(id,place,cnt);
                booksManagements.add(posts);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                rs.close();
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return booksManagements;
    }
    public void deleteById(String id){
        Connection conn = null;
        PreparedStatement pstmt =null;

        String sql1 = "delete from booksmanagement where book_id=?";
        String sql2 = "update booksmanagement set Book_Cnt=? where Book_Id=? ";

        BooksManagement check = findById(id);
        try{
            conn=ds.getConnection();
            if(check.getCnt() == 1) {
                pstmt = conn.prepareStatement(sql1);
                pstmt.setString(1, id);
                int n = pstmt.executeUpdate();
            }
            else{
                pstmt = conn.prepareStatement(sql2);
                pstmt.setInt(1,check.getCnt()-1);
                pstmt.setString(2,id);
                int n = pstmt.executeUpdate();
            }
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
