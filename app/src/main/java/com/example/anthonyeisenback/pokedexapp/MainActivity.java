package com.example.anthonyeisenback.pokedexapp;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String POKEMON_NAME = "http://pokeapi.co/api/v2/";

    @BindView(R.id.poke_name_input_edittext)
    protected EditText pokeName;

    private PokedexFragment pokedexFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    public void onBackPressed() {
      getSupportFragmentManager().beginTransaction().remove(pokedexFragment).commit();
    }

    @OnClick(R.id.submit_button)
    protected void onClickedSubmit() {
        if (pokeName.getText().toString().isEmpty()) {
            Toast.makeText(this, "please make sure to fill out the name", Toast.LENGTH_LONG).show();
        } else {
            pokedexFragment = PokedexFragment.newInstance();
            Bundle bundle = new Bundle();
            bundle.putString(POKEMON_NAME, pokeName.getText().toString());
            pokedexFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, pokedexFragment).commit();
        }

    }
}

