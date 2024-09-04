package com.santiago.pokeproject.application.service;

import com.santiago.pokeproject.domain.model.Pokemon;
import com.santiago.pokeproject.domain.port.PokemonServiceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {

    private final PokemonServiceRepository pokemonServiceRepository;

    public PokemonController(PokemonServiceRepository pokemonServiceRepository) {
        this.pokemonServiceRepository = pokemonServiceRepository;
    }

    @GetMapping
    public List<Pokemon> getPokemons() {
        return pokemonServiceRepository.getPokemons();
    }

}
