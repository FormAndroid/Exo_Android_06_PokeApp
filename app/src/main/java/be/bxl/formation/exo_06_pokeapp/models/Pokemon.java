package be.bxl.formation.exo_06_pokeapp.models;

import java.util.ArrayList;

public class Pokemon {

    private int pokemonId;
    private String name;
    private ArrayList<String> pokemonType;
    private PokemonStats stats;

    public Pokemon(int pokemonId, String name, ArrayList<String> pokemonType, PokemonStats stats) {
        this.pokemonId = pokemonId;
        this.name = name;
        this.pokemonType = pokemonType;
        this.stats = stats;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(ArrayList<String> pokemonType) {
        this.pokemonType = pokemonType;
    }

    public PokemonStats getStats() {
        return stats;
    }

    public void setStats(PokemonStats stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "(" + pokemonId + ") " + name;
    }
}
