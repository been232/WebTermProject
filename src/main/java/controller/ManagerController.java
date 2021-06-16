package controller;

import service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManagerController implements Controller {
    private final ManagerService booksManagerService = new ManagerService();

    @Override
    public ModelAndView process(HttpServletRequest requset, HttpServletResponse response, String url)
        throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        if(url.equals(""));      // url 받기

        return modelAndView;
    }
}
