package uk.me.paulriley.themoviedb.views.nowplaying;

interface NowPlayingPresenter {
    void initialise(NowPlayingView nowPlayingView);
    void onViewResumed();
    void onViewDestroyed();
}
