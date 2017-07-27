package uk.me.paulriley.themoviedb.views.nowplaying;

import android.util.Log;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import uk.me.paulriley.themoviedb.model.FilmListModel;
import uk.me.paulriley.themoviedb.service.TheMovieDbService;

import static android.content.ContentValues.TAG;

class NowPlayingPresenterImpl implements NowPlayingPresenter {
    private NowPlayingView mActivity;
    private TheMovieDbService mTheMovieDBService;

    @Override
    public void initialise(NowPlayingView nowPlayingView) {
        mActivity = nowPlayingView;
    }

    @Override
    public void onViewResumed() {
        Flowable<FilmListModel> mFilmListObservable = mTheMovieDBService.getNowPlaying("");

        mFilmListObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new ShowNowPlayingModelAction(),
                        new NowPlayingFailedAction());
    }

    @Override
    public void onViewDestroyed() {

    }

    private class ShowNowPlayingModelAction implements Consumer<FilmListModel> {
        @Override
        public void accept(FilmListModel filmsListModel) throws Exception {
            if (mActivity != null) {
                mActivity.showNowPlaying(filmsListModel);
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
