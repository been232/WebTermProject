package service;

import domain.BooksManagement;
import persistance.BooksManagerRepository;
import persistance.BooksRepository;

import java.util.ArrayList;

public class BooksManagerService {
    private final BooksManagerRepository booksManagerRepository = BooksManagerRepository.getInstance();
    public BooksManagerService() {
    }
    public void write(BooksManagement booksManagement){
        booksManagerRepository.save(booksManagement);
    }
    public void delete(String id){booksManagerRepository.deleteById(id);}
    public ArrayList<BooksManagement> lookup() {return booksManagerRepository.findAll();}
}
