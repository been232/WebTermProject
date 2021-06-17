package service;

import domain.User;
import persistance.LoginRepository;


public class LoginService {
    private final LoginRepository loginRepository = LoginRepository.getInstacne();
    public LoginService() {
    }
    public User Login(String id, String pw){ return this.loginRepository.certificationLogin(id, pw); }
}
