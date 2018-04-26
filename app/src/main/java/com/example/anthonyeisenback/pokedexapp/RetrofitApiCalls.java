package com.example.anthonyeisenback.pokedexapp;

import android.media.Image;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitApiCalls {
    @GET("{name}")
    Call<PokemonName> getPokemonName(@Path("name") String pokemonName);

    @GET("{front_default}")
    Call<PokemonName> getSprite(@Path("front_shiny") String front);


    class PokemonName {
        @SerializedName("name")
        private String name;

        @SerializedName("front_shiny")
        private String front;

        public String getSprite() {
            return front;
        }

        public String getName() {
            return name;
        }

    }
}