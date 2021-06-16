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
        if(url.equals("/RentalManagement/laon")) {
            ArrayList<RentalManagement> rental = rentalManagementService.findRentals(1);
        }
        return modelAndView;
    }
}
