package uk.me.paulriley.themoviedb.views.nowplaying;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.me.paulriley.themoviedb.R;
import uk.me.paulriley.themoviedb.model.MovieDetailModel;

public class NowPlayingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Context mContext;

    @BindView(R.id.movie_poster)
    ImageView mMoviePoster;
    @BindView(R.id.movie_title)
    TextView mMovieTitle;
    @BindView(R.id.movie_overview)
    TextView mMovieOverview;

    NowPlayingViewHolder(View itemView, Context context) {
        super(itemView);
        mContext = context;
        ButterKnife.bind(this, itemView);
    }

    void initialise(MovieDetailModel movieDetailModel) {
        String posterUrl = "https://image.tmdb.org/t/p/w500" + movieDetailModel.getPosterPath();
        Glide.with(mContext).load(posterUrl).into(mMoviePoster);
        mMovieTitle.setText(movieDetailModel.getTitle());
        mMovieOverview.setText(movieDetailModel.getOverview());
    }

    @Override
    public void onClick(View view) {

    }
}
