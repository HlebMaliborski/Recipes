package com.gangofdevelopers.recipes.presentation.view;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gangofdevelopers.recipes.R;
import com.gangofdevelopers.recipes.presentation.common.BaseFragment;
import com.gangofdevelopers.recipes.presentation.model.RecipeViewData;
import com.gangofdevelopers.recipes.presentation.view.adapter.RecipesListAdapter;
import com.gangofdevelopers.recipes.presentation.viewmodel.MasterRecipeViewModel;
import com.gangofdevelopers.recipes.presentation.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class MasterRecipeFragment extends BaseFragment implements RecipeClickListener {
    @BindView(R.id.recycler_View)
    RecyclerView recyclerView;
    @BindView(R.id.progress_Bar)
    View progressBar;

    @Inject
    ViewModelFactory viewModelFactory;

    private MasterRecipeViewModel viewModel;
    private RecipesListAdapter adapter;

    //Its good idea to not have navController here. We can use some abstraction with commands "navigateTo()".
    private NavController navController;

    @Override
    protected int layoutRes() {
        return R.layout.main_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Transition fadeTransition = new Fade();

        TransitionSet set = new TransitionSet();
        set.addTransition(fadeTransition);

        setExitTransition(set);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        navController = Navigation.findNavController(getBaseActivity(), R.id.nav_host_fragment);
        initializeView();
        initializeViewModel();
    }

    private void initializeView() {
        adapter = new RecipesListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initializeViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MasterRecipeViewModel.class);

        viewModel.getRecipes().observe(this, recipes -> {
            if (recipes != null) {
                recyclerView.setVisibility(View.VISIBLE);
                adapter.setItems(recipes);
            }
        });

        viewModel.getLoading().observe(this, isLoading -> {
            if (isLoading != null) {
                progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
                    recyclerView.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onCLick(ImageView image, TextView text, RecipeViewData data) {
        FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                .addSharedElement(image, image.getTransitionName())
                .addSharedElement(text, text.getTransitionName())
                .build();

        //Need to add strings to Constants class.
        Bundle bundle = new Bundle();
        bundle.putString("url", data.getImageUrl());
        bundle.putString("description", data.getDescription());

        navController.navigate(R.id.detailRecipeFragment, bundle, null, extras);
    }
}
