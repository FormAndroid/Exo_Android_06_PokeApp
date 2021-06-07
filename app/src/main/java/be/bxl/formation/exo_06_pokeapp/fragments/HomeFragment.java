package be.bxl.formation.exo_06_pokeapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import be.bxl.formation.exo_06_pokeapp.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    Button btnSearch, btnFav, btnTeam;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        btnSearch = v.findViewById(R.id.btn_frag_home_search);
        btnFav = v.findViewById(R.id.btn_frag_home_fav);
        btnTeam = v.findViewById(R.id.btn_frag_home_team);

        btnSearch.setOnClickListener(this);
        btnFav.setOnClickListener(this);
        btnTeam.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_frag_home_search) {
            sendNavEvent(SelectedView.SEARCH);
        }
        else if (v.getId() == R.id.btn_frag_home_fav) {
            sendNavEvent(SelectedView.FAV);
        }
        else if (v.getId() == R.id.btn_frag_home_team) {
            sendNavEvent(SelectedView.TEAM);
        }
        else {
            throw  new RuntimeException("Event clic not supported");
        }
    }

    private void sendNavEvent(SelectedView selected) {
        if(navListener != null) {
            navListener.onSelect(selected);
        }
    }

    //region Event
    public enum SelectedView {
        SEARCH,
        FAV,
        TEAM
    }

    @FunctionalInterface
    public interface OnNavListener {
        void onSelect(SelectedView selected);
    }

    private OnNavListener navListener;

    public void setNavListener(OnNavListener navListener) {
        this.navListener = navListener;
    }
    //endregion
}