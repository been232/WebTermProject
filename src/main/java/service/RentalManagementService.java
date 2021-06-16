package service;

import domain.RentalManagement;
import persistance.RentalManagementRepository;

import java.util.ArrayList;

public class RentalManagementService {
    private final RentalManagementRepository rentalManagementRepository = RentalManagementRepository.getInstance();
    public RentalManagementService() {
    }
    public ArrayList<RentalManagement> findRentals(int userNum) {
        return rentalManagementRepository.findRentals(userNum);
    }
}
