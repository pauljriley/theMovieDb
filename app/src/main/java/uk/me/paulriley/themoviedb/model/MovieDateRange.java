package uk.me.paulriley.themoviedb.model;

import android.support.annotation.VisibleForTesting;

import java.io.Serializable;

public class MovieDateRange implements Serializable {
    @VisibleForTesting String maximum;
    @VisibleForTesting String minimum;

    public String getMaximum() {
        return maximum;
    }

    public String getMinimum() {
        return minimum;
    }
}
