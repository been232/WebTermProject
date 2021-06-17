package service;

import persistance.ManagerRepository;

public class ManagerService {
    private final ManagerRepository managerRepository = ManagerRepository.getInstance();
    public ManagerService() {
    }
    public Boolean isManager(String id) {
        return managerRepository.isManager(id);
    }
}
