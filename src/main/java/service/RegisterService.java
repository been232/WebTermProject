package service;

import domain.BooksManagement;
import domain.User;
import persistance.LoginRepository;
import persistance.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistance.UserRepository;

public class RegisterService {
    private final UserRepository userRepository = UserRepository.getInstance();
    public void write(User user){ userRepository.save(user); }
}
