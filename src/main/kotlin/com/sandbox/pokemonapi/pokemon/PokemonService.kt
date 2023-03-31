package com.sandbox.pokemonapi.pokemon

import io.micrometer.observation.annotation.Observed
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PokemonService(
    private val pokemonRepository: PokemonRepository
) {
    @Observed(name = "getListPokemonService")
    fun getListPokemons(offset: String, limit: String): PokemonDto {
        return pokemonRepository.getListPokemons(offset, limit)
    }

    @Observed(name = "getDetailPokemonService")
    fun getDetailPokemon(pokemonName: String): PokemonDetailDto? {
        return pokemonRepository.getDetailPokemon(pokemonName)
    }
}