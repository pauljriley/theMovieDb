package uk.me.paulriley.themoviedb.model;

import android.support.annotation.VisibleForTesting;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieListModel implements Serializable {
    @VisibleForTesting ArrayList<MovieDetailModel> results;
    @VisibleForTesting int page;
    @VisibleForTesting int total_results;
    @VisibleForTesting MovieDateRange dates;
    @VisibleForTesting int total_pages;

    public ArrayList<MovieDetailModel> getResults() {
        return results;
    }

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return total_results;
    }

    public MovieDateRange getDates() {
        return dates;
    }

    public int getTotalPages() {
        return total_pages;
    }
}
