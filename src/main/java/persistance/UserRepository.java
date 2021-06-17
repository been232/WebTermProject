package persistance;

import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserRepository {
    private static UserRepository instance;
    private static DataSource ds;

    public UserRepository()
    {}
    public static UserRepository getInstance() {
        if (instance == null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/MySql");
                return instance = new UserRepository();
            } catch (NamingException var1) {
                var1.printStackTrace();
            }
        }
        return instance;
    }
    public void save(User user){
        String sql = "insert into User(User_Id,User_Password,User_Name) values(?,?,?);";

        Connection conn =null;
        PreparedStatement pstmt = null;
        try{
            conn = ds.getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getId());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getName());

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
