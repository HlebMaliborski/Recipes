package com.gangofdevelopers.recipes.presentation.view.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.gangofdevelopers.recipes.R;
import com.gangofdevelopers.recipes.presentation.model.RecipeViewData;
import com.gangofdevelopers.recipes.presentation.view.RecipeClickListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * In future we can use here DiffUtils to not update view every time if data the same as previous one.
 */
public class RecipesListAdapter extends RecyclerView.Adapter<RecipesListAdapter.RecipeViewHolder> {
    private RecipeClickListener clickListener;
    private final List<RecipeViewData> data = new ArrayList<>();

    public RecipesListAdapter(RecipeClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecipesListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new RecipeViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesListAdapter.RecipeViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setItems(List<RecipeViewData> items) {
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();
    }

    static final class RecipeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recipe_description)
        TextView recipeDescription;
        @BindView(R.id.itemProgressBar)
        ProgressBar progressBar;
        @BindView(R.id.recipe_image)
        ImageView recipeImage;

        private RecipeViewData data;

        RecipeViewHolder(View itemView, RecipeClickListener clickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> clickListener.onCLick(recipeImage, recipeDescription, data));
        }

        void bind(RecipeViewData recipeViewData) {
            data = recipeViewData;
            recipeImage.setTransitionName(recipeViewData.getImageUrl());
            recipeDescription.setTransitionName(recipeViewData.getDescription());

            recipeDescription.setText(recipeViewData.getDescription());
            progressBar.setVisibility(View.VISIBLE);
            Glide.with(recipeImage.getContext())
                    .load(recipeViewData.getImageUrl())
                    .override(1000, 1000)
                    .centerCrop()
                    .addListener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            //show error
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            recipeDescription.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .dontAnimate()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(recipeImage);

        }
    }
}