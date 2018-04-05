package vn.apcs.npkhoa.a2359test.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.apcs.npkhoa.a2359test.R;
import vn.apcs.npkhoa.a2359test.entities.Combination;

import static vn.apcs.npkhoa.a2359test.entities.Combination.MOVIE_TYPE;
import static vn.apcs.npkhoa.a2359test.entities.Combination.PROMOTION_TYPE;

/**
 * Created by khoanguyen on 4/5/18.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Combination> mList;
    private Activity activity;

    public Adapter(Activity activity) {
        mList = new ArrayList<>();
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case MOVIE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
                return new MovieViewHolder(view);
            case PROMOTION_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_promotion, parent, false);
                return new PromotionViewHolder(view);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Combination object = mList.get(position);
        if (object != null) {
            switch (object.getmType()) {
                case MOVIE_TYPE:
                    ((MovieViewHolder) holder).title.setText(object.getMovie().getFilmName());
                    ((MovieViewHolder) holder).showDate.setText(object.getMovie().getPublishDate());
                    Glide.with(activity)
                            .load(object.getMovieImgUrl())
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .centerCrop()
                            .into(((MovieViewHolder) holder).movieThumbnail);
                    break;
                case PROMOTION_TYPE:
                    Glide.with(activity)
                            .load(object.getPromotionImgUrl())
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .centerCrop()
                            .into(((PromotionViewHolder) holder).prmotionThumbnail);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList != null) {
            Combination object = mList.get(position);
            if (object != null) {
                return object.getmType();
            }
        }
        return -1;
    }

    public void setItems(List<Combination> newItems) {
        mList.addAll(newItems);
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movieTitle)
        TextView title;
        @BindView(R.id.showDate)
        TextView showDate;
        @BindView(R.id.movieThumb)
        ImageView movieThumbnail;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class PromotionViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.promotionThumb)
        ImageView prmotionThumbnail;

        public PromotionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
