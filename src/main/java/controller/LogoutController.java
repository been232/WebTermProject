package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController implements Controller{

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ModelAndView modelAndView = new ModelAndView();
        if(url.equals("/Logout/logout")) {
            String userID = (String) session.getAttribute("userID");

            if (userID != null) {
                session.removeAttribute("userID");
                session.removeAttribute("userName");
                session.removeAttribute("userNum");
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
