package pl.droidevs.books.library;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Named;

import pl.droidevs.books.Resource;
import pl.droidevs.books.repository.BookRepository;
import pl.droidevs.books.ui.RxViewModel;

public final class LibraryTransferViewModel extends RxViewModel {

    private final MutableLiveData<Resource<Void>> exportResult = new MutableLiveData<>();
    private final MutableLiveData<Resource<Void>> importResult = new MutableLiveData<>();
    private BookRepository databaseRepository;
    private BookRepository csvRepository;

    @Inject
    LibraryTransferViewModel(@NonNull final BookRepository databaseRepository,
                             @Named("CSV") @NonNull final BookRepository csvRepository) {
        this.databaseRepository = databaseRepository;
        this.csvRepository = csvRepository;
    }

    LiveData<Resource<Void>> exportBooks() {
        add(databaseRepository.fetchAll()
                .take(1)
                .doOnSubscribe(it -> exportResult.setValue(Resource.loading()))
                .subscribe(
                        books -> add(csvRepository.saveAll(books).subscribe(
                                result -> exportResult.setValue(Resource.success()),
                                throwable -> exportResult.setValue(Resource.error(throwable)))
                        ),
                        throwable -> exportResult.setValue(Resource.error(throwable))
                )
        );

        return exportResult;
    }

    LiveData<Resource<Void>> importBooks() {
        add(csvRepository.fetchAll()
                .take(1)
                .doOnSubscribe(it -> importResult.setValue(Resource.loading()))
                .subscribe(
                        books -> add(databaseRepository.saveAll(books).subscribe(
                                result -> importResult.setValue(Resource.success()),
                                throwable -> importResult.setValue(Resource.error(throwable)))
                        ),
                        throwable -> importResult.setValue(Resource.error(throwable))
                )
        );

        return importResult;
    }
}
