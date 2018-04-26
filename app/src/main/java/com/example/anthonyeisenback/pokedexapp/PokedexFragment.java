package com.example.anthonyeisenback.pokedexapp;

import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class PokedexFragment extends Fragment {
    @BindView(R.id.pokemon_name_textview)
    protected TextView pokeName;
    @BindView(R.id.effects_button)
    protected Button effectButton;
    private Retrofit retrofit;
    private String baseUrl = "http://pokeapi.co/api/v2/";



    public static PokedexFragment newInstance() {

        Bundle args = new Bundle();

        PokedexFragment fragment = new PokedexFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pokemon_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


}
