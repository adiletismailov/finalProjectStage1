package service.serviceImpl;

import model.Book;
import service.BookService;

import java.math.BigDecimal;
import java.util.*;

public class BookServiceImpl implements BookService {
    List<Book> bookList = new ArrayList<>();
    List<Book> bookLists = new ArrayList<>();

    @Override
    public List<Book> createBooks(List<Book> books) {
        bookList.addAll(books);
        return bookList;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookList;
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        for (Book b : bookList) {
            if (b.getGenre().name().equals(genre)) {
                bookLists.add(b);
            }
        }
        return bookLists;
    }

    @Override
    public Book removeBookById(Long id) {
        bookList.removeIf(b -> b.getId() == id.longValue());
        return null;
    }

    @Override
    public List<Book> sortBooksByPriceInDescendingOrder() {
        return null;
    }

    @Override
    public List<Book> filterBooksByPublishedYear() {
        return null;
    }

    @Override
    public List<Book> getBookByInitialLetter() {
        return null;
    }

    @Override
    public Book maxPriceBook() {
        return null;
    }
}
