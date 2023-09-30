package in.codebuffdev.junit5.bookstore.service;

import in.codebuffdev.junit5.bookstore.model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> books() {
        return Collections.unmodifiableList(books);
    }
}
