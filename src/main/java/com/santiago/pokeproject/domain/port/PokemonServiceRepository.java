package com.santiago.pokeproject.domain.port;

import com.santiago.pokeproject.domain.model.Pokemon;

import java.util.List;

public interface PokemonServiceRepository {
    List<Pokemon> getPokemons();
}
