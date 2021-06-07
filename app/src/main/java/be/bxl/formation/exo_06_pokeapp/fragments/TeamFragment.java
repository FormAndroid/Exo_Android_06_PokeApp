package be.bxl.formation.exo_06_pokeapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.bxl.formation.exo_06_pokeapp.R;

public class TeamFragment extends Fragment {

    public TeamFragment() {
        // Required empty public constructor
    }

    public static TeamFragment newInstance() {
        return new TeamFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false);
    }
}