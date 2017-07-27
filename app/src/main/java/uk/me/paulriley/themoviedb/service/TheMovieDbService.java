package uk.me.paulriley.themoviedb.service;

import io.reactivex.Flowable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.me.paulriley.themoviedb.MovieDBService;
import uk.me.paulriley.themoviedb.model.FilmListModel;

class TheMovieDbService {

    private MovieDBService mMovieDBService;

    public TheMovieDbService() {
        initialiseWebService("https://api.themoviedb.org/3", new OkHttpClient());
    }

    private void initialiseWebService(String endPoint,
                                      OkHttpClient client) {
        mMovieDBService = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(MovieDBService.class);
    }

    public Flowable<FilmListModel> getNowPlaying(String page) {
        return mMovieDBService.getNowPlaying("/movie/now_playing",
                "36a8b09836dc346226e46e4ed4220f48",
                "en-US", page, "");
    }
}
