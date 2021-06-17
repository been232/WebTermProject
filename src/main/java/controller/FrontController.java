package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontController", urlPatterns = "/front/*")
public class FrontController extends HttpServlet {
    private Map<String, Controller> controllerMap = new HashMap<>();

    public FrontController() {
        //controllerMap.put("domain 이름", new 도메인 컨트롤러);             // domain이름에 "member", 컨트롤러는 생성자 작성하면됨
        controllerMap.put("Login", new LoginController());
        controllerMap.put("RentalManagement", new RentalManagementController());
        controllerMap.put("BooksManagement",new BooksManagementController());
        controllerMap.put("Books", new BooksController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        conPath += "/front";
        String com = uri.substring(conPath.length());

        if(com.equals("/")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/main.jsp");
            dispatcher.forward(request, response);
        }
        else {
            String [] tokens = com.split("/");
            String domain = tokens[1];
            Controller controller = controllerMap.get(domain);
            if(controller == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            ModelAndView mv = controller.process(request, response, com);
            String viewPath = viewResolver(mv.getViewName());
            View view = new View(viewPath);
            view.render(mv.getModel(), request, response);
        }
    }

    private String viewResolver(String viewName) {
        return "/WEB-INF/view/" + viewName + ".jsp";
    }
}
