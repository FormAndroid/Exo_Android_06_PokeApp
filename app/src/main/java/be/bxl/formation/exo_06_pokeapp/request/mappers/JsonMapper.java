package be.bxl.formation.exo_06_pokeapp.request.mappers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import be.bxl.formation.exo_06_pokeapp.models.Pokemon;
import be.bxl.formation.exo_06_pokeapp.models.PokemonStats;

public class JsonMapper {

    private JsonMapper() {};

    public static Pokemon convertToPokemon(JSONObject json) {
        Pokemon result = null;

        try {
            String name = json.getString("name");
            int id = json.getInt("id");

            ArrayList<String> pokemonTypes = new ArrayList<>();
            JSONArray jsonTypes = json.getJSONArray("types");
            for (int i = 0; i < jsonTypes.length(); i++) {
                JSONObject data = jsonTypes.getJSONObject(i);
                String pokemonType = data.getJSONObject("type").getString("name");
                pokemonTypes.add(pokemonType);
            }

            JSONArray jsonStats = json.getJSONArray("stats");
            PokemonStats pokemonStats = new PokemonStats(
                    jsonStats.getJSONObject(0).getInt("base_stat"),
                    jsonStats.getJSONObject(1).getInt("base_stat"),
                    jsonStats.getJSONObject(2).getInt("base_stat"),
                    jsonStats.getJSONObject(3).getInt("base_stat"),
                    jsonStats.getJSONObject(4).getInt("base_stat"),
                    jsonStats.getJSONObject(5).getInt("base_stat")
            );

            result = new Pokemon(
                    id,
                    name,
                    pokemonTypes,
                    pokemonStats
            );

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
}
