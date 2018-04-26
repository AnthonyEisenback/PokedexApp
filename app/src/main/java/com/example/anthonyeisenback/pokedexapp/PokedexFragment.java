package com.example.anthonyeisenback.pokedexapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.anthonyeisenback.pokedexapp.MainActivity.POKEMON_NAME;

public class PokedexFragment extends Fragment {
    private RetrofitApiCalls retrofitApiCalls;
    @BindView(R.id.pokemon_name_textview)
    protected TextView pokeName;
    @BindView(R.id.effects_button)
    protected Button effectButton;
    @BindView(R.id.pokemon_image)
    protected ImageView imageView;
    private Retrofit retrofit;
    private String baseUrl = "http://pokeapi.co/api/v2/pokemon/";


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
        String strtext = getArguments().getString(POKEMON_NAME);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        String pokemonName = getArguments().getString(POKEMON_NAME);

        buildRetrofit();
        makeApiCall(pokemonName);
    }

    private void makeApiCall(final String pokemonName) {
        retrofitApiCalls.getPokemonName(pokemonName).enqueue(new Callback<RetrofitApiCalls.PokemonName>() {
            @Override
            public void onResponse(Call<RetrofitApiCalls.PokemonName> call, Response<RetrofitApiCalls.PokemonName> response) {

                if (response.isSuccessful()) {
                    pokeName.setText(response.body().getName());
                    Glide.with(getActivity()).load(response.body().getSprite()).into(imageView);

                }else {
                    Toast.makeText(getContext(), "Sorry, but an Error occurred", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RetrofitApiCalls.PokemonName> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

    private void buildRetrofit() {
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();

        retrofitApiCalls = retrofit.create(RetrofitApiCalls.class);
    }
}
