package persistance;

import domain.Manager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerRepository {
    private static ManagerRepository instance;
    private static DataSource ds;

    public ManagerRepository() {

    }

    public static ManagerRepository getInstance() {
        if(instance == null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/MySql");
                return instance = new ManagerRepository();
            } catch (NamingException var1) {
                var1.printStackTrace();
            }
        }
        return instance;
    }

    public boolean isManager(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean isManager = false;
        String sql = "SELECT Manager_Num FROM manager WHERE Manager_Id = ?";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs == null) return false;
            while(rs.next()) {
                if(rs.getString("Manager_Num") != null) {
                    isManager = true;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return isManager;
    }
}
