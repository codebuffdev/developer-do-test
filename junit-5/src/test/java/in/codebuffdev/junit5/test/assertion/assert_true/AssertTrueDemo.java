package in.codebuffdev.junit5.test.assertion.assert_true;

import in.codebuffdev.junit5.bookstore.model.Book;
import in.codebuffdev.junit5.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertTrueDemo {

    @Test
    public void assertTrueWithNoMessage(){
        BookService bookService = new BookService();
        List<Book> bookList = bookService.books();
        assertTrue(bookList.isEmpty());
    }

    @Test
    public void assertTrueWithMessage(){
        BookService bookService = new BookService();
        Book book = new Book("1","Head First Java", "Worx");
        bookService.addBook(book);
        List<Book> bookList = bookService.books();
        assertTrue(bookList.isEmpty(),"List books is not empty");
    }

    @Test
    public void assertTrueWithMessageSupplier(){
        BookService bookService = new BookService();
        Book book = new Book("1","Head First Java", "Worx");
        bookService.addBook(book);
        List<Book> bookList = bookService.books();
        assertTrue(bookList.isEmpty(), () -> "List books is not EMPTY");
    }

    @Test
    public void assertTrueWithBooleanSupplierAndNoMessage(){
        BookService bookService = new BookService();
        List<Book> bookList = bookService.books();
        assertTrue(() -> bookList.isEmpty());
    }

    @Test
    public void assertTrueWithBooleanSupplierAndMessage(){
        BookService bookService = new BookService();
        Book book = new Book("1","Head First Java", "Worx");
        bookService.addBook(book);
        List<Book> bookList = bookService.books();
        assertTrue(() -> bookList.isEmpty(),"List books is not empty");
    }

    @Test
    public void assertTrueWithBooleanSupplierAndMessageSupplier(){
        BookService bookService = new BookService();
        Book book = new Book("1","Head First Java", "Worx");
        bookService.addBook(book);
        List<Book> bookList = bookService.books();
        assertTrue(() -> bookList.isEmpty(),() ->
                "List books is not EMPTY");
    }
}
