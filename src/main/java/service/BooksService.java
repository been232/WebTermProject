package service;

import domain.Books;
import persistance.BooksRepository;

public class BooksService {
    private final BooksRepository booksRepository = BooksRepository.getInstance();
    public BooksService() {
    }
    public void write(Books books){
        booksRepository.save(books);
    }
}
