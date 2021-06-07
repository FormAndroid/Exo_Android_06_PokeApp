package be.bxl.formation.exo_06_pokeapp.fragments;

import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import be.bxl.formation.exo_06_pokeapp.R;
import be.bxl.formation.exo_06_pokeapp.models.Pokemon;
import be.bxl.formation.exo_06_pokeapp.request.PokemonRequestTask;

public class SearchFragment extends Fragment
        implements PokemonRequestTask.OnResultRequestListener {

    private EditText etSearchId;
    private ImageView imgAction;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        etSearchId = v.findViewById(R.id.et_frag_search_id);
        etSearchId.setOnEditorActionListener((v1, actionId, event) -> {
            if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchPokemon();
                return true;
            }
            return false;
        });

        imgAction = v.findViewById(R.id.img_frag_search_action);
        imgAction.setOnClickListener(v1 -> searchPokemon());

        return v;
    }

    public void searchPokemon() {
        int searchId = Integer.parseInt(etSearchId.getText().toString());

        PokemonRequestTask task = new PokemonRequestTask();
        task.setListener(this);
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, searchId);
    }

    @Override
    public void onPokemonResult(Pokemon pokemon) {
        Toast.makeText(getContext(), pokemon.getName(), Toast.LENGTH_SHORT).show();
    }
}