package service;

import domain.BooksManagement;
import persistance.BooksManagerRepository;
import persistance.BooksRepository;

public class BooksManagerService {
    private final BooksManagerRepository booksManagerRepository = BooksManagerRepository.getInstance();
    public BooksManagerService() {
    }
    public void write(BooksManagement booksManagement){
        booksManagerRepository.save(booksManagement);
    }
}
