package controller;

import domain.Books;
import domain.BooksManagement;
import service.BooksManagerService;
import service.BooksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class BooksController implements Controller {
    private final BooksService booksService = new BooksService();
    private final BooksManagerService booksManagerService = new BooksManagerService();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        if (url.equals("/Books/show")) {

            ArrayList<Books> bookList = booksService.lookup();
            ArrayList<BooksManagement> bookManagerList = booksManagerService.lookup();
            modelAndView.setViewName("Books/showBooksList");
            modelAndView.getModel().put("books", bookList);
            modelAndView.getModel().put("place", bookManagerList);

        }

        return modelAndView;
    }
}
