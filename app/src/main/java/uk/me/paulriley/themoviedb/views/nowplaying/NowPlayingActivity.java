package uk.me.paulriley.themoviedb.views.nowplaying;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.me.paulriley.themoviedb.R;
import uk.me.paulriley.themoviedb.model.MovieDetailModel;
import uk.me.paulriley.themoviedb.model.MovieListModel;

public class NowPlayingActivity extends AppCompatActivity implements NowPlayingView {
    static final String BASE_URL = "https://api.themoviedb.org/3/";

    private NowPlayingPresenter mPresenter;
    private NowPlayingAdapter mNowPlayingAdapter;

    @BindView(R.id.now_playing_list)
    RecyclerView mFilmList;

    public NowPlayingActivity() {
        mNowPlayingAdapter = new NowPlayingAdapter(this);
        mPresenter = new NowPlayingPresenterImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        ButterKnife.bind(this);
        mPresenter.initialise(this);

        initialiseRecyclerView();
    }

    private void initialiseRecyclerView() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mFilmList.setLayoutManager(mLayoutManager);
        mFilmList.setAdapter(mNowPlayingAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onViewResumed();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onViewDestroyed();
        super.onDestroy();
    }

    @Override
    public void showNowPlaying(MovieListModel movieListModel) {
        ArrayList<MovieDetailModel> movieList = movieListModel.getResults();

        if (movieList != null && movieList.size() > 0) {
            mNowPlayingAdapter.addNewItems(movieList);
        }
    }
}
