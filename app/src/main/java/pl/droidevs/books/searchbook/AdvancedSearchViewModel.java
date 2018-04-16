package pl.droidevs.books.searchbook;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import javax.inject.Inject;

import pl.droidevs.books.Resource;
import pl.droidevs.books.domain.Book;
import pl.droidevs.books.domain.BookId;
import pl.droidevs.books.repository.BookRepository;
import pl.droidevs.books.ui.RxViewModel;
import pl.droidevs.books.validators.BookInputValidator;

public class AdvancedSearchViewModel extends RxViewModel {

    private String author;
    private String year;
    private String publisher;
    private float rating;
    private String category;



    private MutableLiveData<Resource<Book>> bookLiveData = new MutableLiveData<>();
}
