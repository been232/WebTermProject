package controller;

import domain.User;
import persistance.ManagerRepository;
import service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.io.IOException;
import service.LoginService;
import service.ManagerService;

public class LoginController implements Controller {
    private final LoginService loginService = new LoginService();
    private final ManagerService managerService = new ManagerService();
    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        if(url.equals("/Login/login")) {
            HttpSession session = request.getSession();
            String id = "";
            String pw = "";
            User loginResult;
            modelAndView.setViewName("Login/login");
            if(request.getMethod().equals("POST"))
            {
                id = request.getParameter("id");
                pw = request.getParameter("pw");
                loginResult = this.loginService.Login(id, pw);
                if(loginResult != null)
                {
                    managerService.isManager(id);
                    boolean isManager = managerService.isManager(id);
                    session.setAttribute("isManager", isManager);
                    session.setAttribute("userID", id);
                    session.setAttribute("userName", loginResult.getName());
                    session.setAttribute("userNum", loginResult.getNum());
                    modelAndView.setViewName("main");
                    System.out.println("로그인 성공");
                }
            }
            String userID = (String) session.getAttribute("userID");
            if(userID != null)
            {
                response.sendRedirect("/front/");
                modelAndView.setViewName("main");
            }
        }
        else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        return modelAndView;
    }
}
