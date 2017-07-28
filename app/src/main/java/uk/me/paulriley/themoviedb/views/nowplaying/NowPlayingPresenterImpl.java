package uk.me.paulriley.themoviedb.views.nowplaying;

import android.util.Log;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import uk.me.paulriley.themoviedb.model.MovieListModel;
import uk.me.paulriley.themoviedb.service.TheMovieDbService;

import static android.content.ContentValues.TAG;

class NowPlayingPresenterImpl implements NowPlayingPresenter {
    private NowPlayingView mActivity;
    private TheMovieDbService mTheMovieDBService = new TheMovieDbService(NowPlayingActivity.BASE_URL);

    @Override
    public void initialise(NowPlayingView nowPlayingView) {
        mActivity = nowPlayingView;
    }

    @Override
    public void onViewResumed() {
        Flowable<MovieListModel> mFilmListObservable = mTheMovieDBService.getNowPlaying("");

        mFilmListObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new ShowNowPlayingModelAction(),
                        new NowPlayingFailedAction());
    }

    @Override
    public void onViewDestroyed() {

    }

    private class ShowNowPlayingModelAction implements Consumer<MovieListModel> {
        @Override
        public void accept(MovieListModel movieListModel) throws Exception {
            if (mActivity != null) {
                mActivity.showNowPlaying(movieListModel);
            }
        }
    }

    private class NowPlayingFailedAction implements Consumer<Throwable> {
        @Override
        public void accept(Throwable throwable) throws Exception {
            Log.e(TAG, "Error retrieving movies", throwable);
        }
    }
}
