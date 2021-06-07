package be.bxl.formation.exo_06_pokeapp.request;

import android.os.AsyncTask;

import org.json.JSONObject;

import be.bxl.formation.exo_06_pokeapp.helpers.RequestHelper;
import be.bxl.formation.exo_06_pokeapp.models.Pokemon;
import be.bxl.formation.exo_06_pokeapp.request.mappers.JsonMapper;

public class PokemonRequestTask extends AsyncTask<Integer, Void, Pokemon> {

    //region Event
    @FunctionalInterface
    public interface OnResultRequestListener {
        void onPokemonResult(Pokemon pokemon);
    }

    private OnResultRequestListener listener;

    public void setListener(OnResultRequestListener listener) {
        this.listener = listener;
    }
    //endregion

    private String URL_BASE = "https://pokeapi.co/api/v2/pokemon/__query__";

    @Override
    protected Pokemon doInBackground(Integer... integers) {
        if(listener == null) {
            throw  new RuntimeException("No listener !");
        }

        if(integers == null || integers.length != 1 || integers[0] < 0) {
            return null;
        }

        String url = URL_BASE.replace("__query__", String.valueOf(integers[0]));
        JSONObject data = RequestHelper.sendRequestGet(url);

        if(data != null) {
            return JsonMapper.convertToPokemon(data);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Pokemon pokemon) {
        if(listener != null) {
            listener.onPokemonResult(pokemon);
        }
    }
}
