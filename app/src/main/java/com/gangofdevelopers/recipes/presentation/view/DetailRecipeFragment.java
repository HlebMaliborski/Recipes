package com.gangofdevelopers.recipes.presentation.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.TransitionInflater;
import android.view.View;
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
import com.gangofdevelopers.recipes.presentation.common.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;

public class DetailRecipeFragment extends BaseFragment {
    @BindView(R.id.detail_recipe_image)
    ImageView imageView;
    @BindView(R.id.detail_recipe_description)
    TextView textView;
    @BindView(R.id.detail_progress_Bar)
    ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSharedElementEnterTransition(TransitionInflater.from(getBaseActivity()).inflateTransition(R.transition.image_shared_element_transition));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String url = getArguments().getString("url");
        String description = getArguments().getString("description");

        imageView.setTransitionName(url);
        textView.setTransitionName(description);

        Glide.with(getBaseActivity())
                .load(url)
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
                        //Instead of checking for null better to stop glide
                        if (textView != null) {
                            textView.setVisibility(View.VISIBLE);
                            textView.setText(description);
                        }
                        if (progressBar != null) {
                            progressBar.setVisibility(View.GONE);
                        }
                        return false;
                    }
                })
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(imageView);
    }

    @Override
    protected int layoutRes() {
        return R.layout.detail_recipe_fragment;
    }
}
