package controller;

import domain.User;
import service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class RegisterController implements Controller {
    private final RegisterService registerService = new RegisterService();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        if(url.equals("/Register/register"));    // jsp 에서 url 던지면 여기서 받아야함
        {
            modelAndView.setViewName("/Register/register");
            if(request.getMethod().equals("POST")){
                String id = request.getParameter("id");
                String pw = request.getParameter("pw");
                String name = request.getParameter("name");
                User user = new User();
                user.setId(id);
                user.setPassword(pw);
                user.setName(name);
                registerService.write(user);
                response.sendRedirect("/front/");
                modelAndView.setViewName("main");
            }
        }
        return modelAndView;
    }
}
