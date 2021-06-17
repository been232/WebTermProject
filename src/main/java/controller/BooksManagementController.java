package controller;

import domain.Books;
import domain.BooksManagement;
import service.BooksManagerService;
import service.BooksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class BooksManagementController implements Controller{
    private final BooksManagerService booksManagerService = new BooksManagerService();
    private final BooksService booksService = new BooksService();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
        throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        if(url.equals("/BooksManagement/create"));    // jsp 에서 url 던지면 여기서 받아야함
        {
            modelAndView.setViewName("BooksManagement/create");
            if(request.getMethod().equals("POST")){
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String writer = request.getParameter("writer");
                String publisher = request.getParameter("publisher");
                String place = request.getParameter("place");
                Books book = new Books();
                BooksManagement booksManagement = new BooksManagement();
                book.setId(id);
                book.setName(name);
                book.setWriter(writer);
                book.setPublisher(publisher);
                book.setRegistraion(LocalDateTime.now());
                booksManagement.setId(id);
                booksManagement.setPlace(place);
                booksManagerService.write(booksManagement);
                booksService.write(book);

                modelAndView.setViewName("main");
            }
        }
        if(url.equals("/BooksManagement/delete"));    // jsp 에서 url 던지면 여기서 받아야함
        {
            modelAndView.setViewName("BooksManagement/delete");
            if(request.getMethod().equals("POST")){
                int num = Integer.parseInt(request.getParameter("num"));
                String id = request.getParameter("id");
                booksService.delete(num);
                booksManagerService.delete(id);

                modelAndView.setViewName("main");
            }
        }
        return modelAndView;
    }
}
