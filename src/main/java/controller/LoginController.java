package controller;

import service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class LoginController implements Controller {
    private final LoginService loginService = new LoginService();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        if(url.equals("/Login/login")) {
            modelAndView.setViewName("Login/login");
        }
        else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        return modelAndView;
    }
}
