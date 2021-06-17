package controller;

import domain.RentalManagement;
import service.RentalManagementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class RentalManagementController implements Controller {
    private final RentalManagementService rentalManagementService = new RentalManagementService();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        if(url.equals("/RentalManagement/loan")) {
            int userNum = Integer.parseInt(request.getParameter("id"));
            System.out.println(userNum);
            ArrayList<RentalManagement> rentals = rentalManagementService.findRentals(userNum);
            modelAndView.setViewName("RentalManagement/loan");
            modelAndView.getModel().put("rentals", rentals);
        }

        return modelAndView;
    }
}
