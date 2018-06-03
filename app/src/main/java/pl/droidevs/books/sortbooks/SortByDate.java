package pl.droidevs.books.sortbooks;

import java.util.Collections;
import java.util.List;
import java.util.Comparator;

import pl.droidevs.books.dao.BookDao;
import pl.droidevs.books.domain.Book;

public class SortByDate {

    public List<Book> sortByDate(BookDao bookDao) {
        List<Book> allBooks = bookDao.getAllBooksListed();
        Collections.sort(allBooks, new Comparator<Book>() {
            public int compare(Book book1, Book book2) {
                return book1.getSaveDate().compareTo(book2.getSaveDate());
            }
        });

        return allBooks;
    }
}
