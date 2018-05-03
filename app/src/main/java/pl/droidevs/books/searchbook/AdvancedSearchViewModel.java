package pl.droidevs.books.searchbook;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;


import javax.inject.Inject;

import pl.droidevs.books.Resource;
import pl.droidevs.books.domain.Book;
import pl.droidevs.books.library.LibraryActivity;
import pl.droidevs.books.repository.BookFilter;
import pl.droidevs.books.repository.BookRepository;
import pl.droidevs.books.ui.RxViewModel;

import static android.text.TextUtils.isEmpty;

public class AdvancedSearchViewModel extends RxViewModel {

    private String author;
    private String year;
    private String publisher;
    private float rating;
    private String category;

    public void setYear(String year) {
        this.year = year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private final BookRepository bookRepository;
    private MutableLiveData<Resource<Book>> bookLiveData = new MutableLiveData<>();



    @Inject
    AdvancedSearchViewModel(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    void searchBooks() {



    }







}
