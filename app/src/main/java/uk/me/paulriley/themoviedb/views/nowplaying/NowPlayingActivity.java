package uk.me.paulriley.themoviedb.views.nowplaying;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.me.paulriley.themoviedb.NowPlayingPresenter;
import uk.me.paulriley.themoviedb.NowPlayingPresenterImpl;
import uk.me.paulriley.themoviedb.NowPlayingView;
import uk.me.paulriley.themoviedb.R;
import uk.me.paulriley.themoviedb.model.FilmListModel;

public class NowPlayingActivity extends AppCompatActivity implements NowPlayingView {

    private NowPlayingPresenter mPresenter;
    private LinearLayoutManager mLayoutManager;

    @BindView(R.id.now_playing_list)
    RecyclerView mFilmList;

    public NowPlayingActivity() {
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
        mLayoutManager = new LinearLayoutManager(this);
        mFilmList.setLayoutManager(mLayoutManager);
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
    public void showNowPlaying(FilmListModel filmsListModel) {

    }
}
