package controller;

import service.BooksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BooksController implements Controller{
    private final BooksService booksService = new BooksService();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        if(url.equals(""));    // jsp 에서 url 던지면 여기서 받아야함


        return modelAndView;
    }
}
