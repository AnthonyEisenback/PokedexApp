package com.example.anthonyeisenback.pokedexapp;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitApiCalls {
    @GET("api/v2/pokemon/{name}")
    Call<PokemonName> getPokemonName(@Path("name") String pokemonName);

    class PokemonName {
        @SerializedName("name")
        private String name;

        public String getName() {
            return name;
        }

    }
}
