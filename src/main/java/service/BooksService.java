package service;

import domain.Books;
import persistance.BooksRepository;

import java.util.ArrayList;

public class BooksService {
    private final BooksRepository booksRepository = BooksRepository.getInstance();
    public BooksService() {
    }
    public void write(Books books){
        booksRepository.save(books);
    }
    public ArrayList<Books> lookup() {return booksRepository.look();}
}
