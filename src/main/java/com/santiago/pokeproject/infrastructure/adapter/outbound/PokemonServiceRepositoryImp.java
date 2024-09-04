package com.santiago.pokeproject.infrastructure.adapter.outbound;

import com.santiago.pokeproject.domain.model.Pokemon;
import com.santiago.pokeproject.domain.port.PokemonServiceRepository;
import com.santiago.pokeproject.infrastructure.adapter.config.PokeApiProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PokemonServiceRepositoryImp implements PokemonServiceRepository {

    private final RestTemplate restTemplate;
    private final PokeApiProperties pokeApiProperties;

    public PokemonServiceRepositoryImp(RestTemplate restTemplate, PokeApiProperties pokeApiProperties) {
        this.restTemplate = restTemplate;
        this.pokeApiProperties = pokeApiProperties;
    }

    @Override
    public List<Pokemon> getPokemons() {
        String pokeApiUri = pokeApiProperties.getBaseUrl()+"pokemon?limit=150";
        PokemonResponse response = restTemplate.getForObject(pokeApiUri, PokemonResponse.class);
        return response != null ? Arrays.asList(response.getResults()) : null;
    }

    public static class PokemonResponse {

        private Pokemon[] results;

        public Pokemon[] getResults() {
            return results;
        }

        public void setResults(Pokemon[] results) {
            this.results = results;
        }
    }
}
