package pl.droidevs.books.searchbook;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;
import dagger.android.AndroidInjection;
import pl.droidevs.books.R;
import pl.droidevs.books.domain.Book;
import pl.droidevs.books.domain.BookId;
import pl.droidevs.books.removebook.RemoveBookDialogFragment;
import pl.droidevs.books.removebook.RemoveBookViewModel;
import pl.droidevs.books.savebook.SaveBookViewModel;

import static com.bumptech.glide.Priority.HIGH;
import static pl.droidevs.books.Resource.Status.ERROR;
import static pl.droidevs.books.Resource.Status.SUCCESS;

public class AdvancedSearchActivity extends AppCompatActivity {

    @BindView(R.id.author_tv)
    TextView authorTextView;

    @BindView(R.id.year_tv)
    TextView yearTextView;

    @BindView(R.id.publisher_tv)
    TextView publisherTextView;

    @BindView(R.id.rating_tv)
    RatingBar ratingTextView;

    @BindView(R.id.category_tv)
    TextView categoryTextView;

    @BindView(R.id.categorySpinner)
    Spinner categorySpinner;

    @BindView(R.id.authorEditText)
    EditText authorEditText;

    @BindView(R.id.yearEditText)
    EditText yearEditText;

    @BindView(R.id.publisherEditText)
    EditText publisherEditText;

    @BindView(R.id.ratingBar)
    RatingBar ratingBar;

    @BindView(R.id.searchButton)
    Button searchButton;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private AdvancedSearchViewModel advancedSearchViewModel;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);

        getWindow().setEnterTransition(new Fade().setDuration(getResources().getInteger(R.integer.animation_base_duration)));

        AndroidInjection.inject(this);
        ButterKnife.bind(this);

        setupSpinner();
        setupViewModel();
    }

    private void setupSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getCategoryNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        categorySpinner.setAdapter(adapter);
    }
    private List<String> getCategoryNames() {
        Book.Category[] categories = Book.Category.values();
        List<String> categoryNames = new ArrayList<>();

        for (Book.Category category : categories) {
            categoryNames.add(category.toString());
        }

        return categoryNames;
    }

    private void setupViewModel() {
        final AdvancedSearchViewModel viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(AdvancedSearchViewModel.class);
    }



    @OnClick(R.id.searchButton)
    void onSearchButtonClicked() {


    }

    public static void startForResult(@NonNull final Activity context, @NonNull final BookId bookId) {
        Intent intent = new Intent(context, AdvancedSearchActivity.class);

    }


}
