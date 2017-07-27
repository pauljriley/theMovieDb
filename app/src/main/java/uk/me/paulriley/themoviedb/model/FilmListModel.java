package uk.me.paulriley.themoviedb.model;

import java.io.Serializable;
import java.util.ArrayList;

public class FilmListModel implements Serializable {
    private int vote_count;
    private int id;
    private boolean video;
    private double vote_average;
    private String title;
    private double popularity;
    private String poster_path;
    private String original_language;
    private String original_title;
    private ArrayList<Integer> genre_ids;
    private String backdrop_path;
    private boolean adult;
    private String overview;
    private String release_date;


    public int getVoteCount() {
        return vote_count;
    }

    public int getId() {
        return id;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVoteAverage() {
        return vote_average;
    }

    public String getTitle() {
        return title;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public String getOriginalLanguage() {
        return original_language;
    }

    public String getOriginalTitle() {
        return original_title;
    }

    public ArrayList<Integer> getGenreIds() {
        return genre_ids;
    }

    public String getBackdropPath() {
        return backdrop_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return release_date;
    }
}
