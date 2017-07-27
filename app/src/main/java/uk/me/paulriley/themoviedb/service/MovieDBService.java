package uk.me.paulriley.themoviedb.service;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import uk.me.paulriley.themoviedb.model.FilmListModel;

interface MovieDBService {
    @GET("{method}")
    Flowable<FilmListModel> getNowPlaying(@Path("method") String method,
                                          @Query("api_key") String apiKey,
                                          @Query("language") String language,
                                          @Query("page") String page,
                                          @Query("region") String region);
}
