package uk.me.paulriley.themoviedb.service;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uk.me.paulriley.themoviedb.model.MovieListModel;

interface MovieDBService {
    @GET("movie/now_playing/")
    Flowable<MovieListModel> getNowPlaying(@Query("api_key") String apiKey,
                                           @Query("language") String language,
                                           @Query("page") String page,
                                           @Query("region") String region);
}
