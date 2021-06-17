package persistance;

import domain.Manager;
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

public class LoginRepository {
    private static LoginRepository instance;
    private static DataSource ds;

    private LoginRepository() {
    }

    public static LoginRepository getInstacne() {
        if (instance == null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/MySql");
                return instance = new LoginRepository();
            } catch (NamingException var1) {
                var1.printStackTrace();
            }
        }

        return instance;
    }

    public User certificationLogin(String id, String pw) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String dbPassword = "";
        String sql = "SELECT * FROM USER WHERE User_Id = ?";
        //   int result = 0;
        User result = null;
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                dbPassword = rs.getString("User_Passward");
                String userName = rs.getString("User_Name");
                int userNum = rs.getInt("User_Num");
                if (dbPassword.equals(pw)) {
                    result = new User();
                    result.setPassward(dbPassword);
                    result.setName(userName);
                    result.setNum(userNum);
                }
            }
        } catch (SQLException var20) {
            var20.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException var19) {
                var19.printStackTrace();
            }
        }
        return result;
    }
}

