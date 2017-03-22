package com.androidprojects.esprit.moviessampleapp;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Amal on 15/03/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Movie> moviesList;

    public MoviesAdapter(Context mContext, List<Movie> moviesList) {
        this.mContext = mContext;
        this.moviesList = moviesList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, rating;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            rating= (TextView) view.findViewById(R.id.rating);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }

    @Override
    public MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MoviesAdapter.MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.name.setText(movie.getName());
        holder.rating.setText("Rating: "+String.valueOf( movie.getRating()));

        /**  loading movies posters using Glide library **/
        Glide.with(mContext).load(movie.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    /** showing popup menu when tapping on 3 dots **/
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_movie, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }
    /** click listener for popup menu items **/
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_rate:
                    Toast.makeText(mContext, "Rate", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_share:
                    Toast.makeText(mContext, "Share", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
}
