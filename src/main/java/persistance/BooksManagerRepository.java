package persistance;

import domain.BooksManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
    }
    public void save(BooksManagement booksManagement){

    }
}
