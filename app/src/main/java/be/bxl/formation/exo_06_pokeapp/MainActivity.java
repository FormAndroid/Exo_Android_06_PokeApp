package be.bxl.formation.exo_06_pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import be.bxl.formation.exo_06_pokeapp.fragments.FavFragment;
import be.bxl.formation.exo_06_pokeapp.fragments.HomeFragment;
import be.bxl.formation.exo_06_pokeapp.fragments.SearchFragment;
import be.bxl.formation.exo_06_pokeapp.fragments.TeamFragment;

public class MainActivity extends AppCompatActivity implements  HomeFragment.OnNavListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment home = HomeFragment.newInstance();
        home.setNavListener(this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frag_main_content, home);
        transaction.commit();
    }

    @Override
    public void onSelect(HomeFragment.SelectedView selected) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment frag;
        switch (selected) {
            case SEARCH:
                frag = SearchFragment.newInstance();
                break;
            case FAV:
                frag = FavFragment.newInstance();
                break;
            case TEAM:
                frag = TeamFragment.newInstance();
                break;
            default:
                throw new RuntimeException("Not supported fragment");
        }

        transaction.replace(R.id.frag_main_content, frag);

        transaction.setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.slide_out_right);

        transaction.addToBackStack(null);

        transaction.commit();
    }

}
