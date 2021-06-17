package controller;

import domain.Books;
import domain.BooksManagement;
import service.BooksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class BooksController implements Controller{
    private final BooksService booksService = new BooksService();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        if(url.equals("/front/Books")){
            modelAndView.setViewName("/Books");
            if(request.getMethod().equals("LOOK")){
                ArrayList<Books> bookList = new ArrayList<>();
                bookList = booksService.lookup();
                for(Books book : bookList){
                    System.out.print(book.getId() + ", ");
                    System.out.print(book.getName() + ", ");
                    System.out.print(book.getWriter() + ", ");
                    System.out.print(book.getPublisher());
                    System.out.println();
                }

            }
        }

        return modelAndView;
    }
}
