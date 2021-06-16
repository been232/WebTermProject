package persistance;

import domain.Books;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.awt.print.Book;

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

    }
}
