package uk.me.paulriley.themoviedb.views.nowplaying;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import uk.me.paulriley.themoviedb.R;
import uk.me.paulriley.themoviedb.model.MovieDetailModel;

public class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingViewHolder> implements NowPlayingCallback {
    private final Context mContext;

    private ArrayList<MovieDetailModel> mMovieList = new ArrayList<>();

    NowPlayingAdapter(Context context) {
        mContext = context;
    }

    @Override
    public NowPlayingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.now_playing_item, parent, false);
        return new NowPlayingViewHolder(contentView, mContext);
    }

    @Override
    public void onBindViewHolder(NowPlayingViewHolder viewHolder, int position) {
        viewHolder.initialise(mMovieList.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    void addNewItems(ArrayList<MovieDetailModel> movieList) {
        mMovieList.addAll(movieList);
        notifyDataSetChanged();
    }

    @Override
    public void navigateToMovieDetails(int movieId) {

    }
}
