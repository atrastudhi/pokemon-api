package com.sandbox.pokemonapi.pokemon

import com.fasterxml.jackson.databind.ObjectMapper
import io.micrometer.observation.annotation.Observed
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException

@Repository
class PokemonRepository(
    private val pokemonWebClient: WebClient,
    private val objectMapper: ObjectMapper,
) {
    @Observed(name = "getListPokemonRepository")
    fun getListPokemons(offset: String, limit: String): PokemonDto {
        return try {
            val body = pokemonWebClient
                .get()
                .uri("/pokemon/?offset={offset}&limit={limit}", offset, limit)
                .retrieve()
                .bodyToMono(String::class.java)
                .block()
            objectMapper.readValue(
                body,
                PokemonDto::class.java
            )
        } catch (ex: WebClientResponseException) {
            throw ex
        }
    }

    @Observed(name = "getDetailPokemonRespository")
    fun getDetailPokemon(pokemonName: String): PokemonDetailDto? {
        return try {
            val body = pokemonWebClient
                .get()
                .uri("/pokemon/{pokemonName}", pokemonName)
                .retrieve()
                .bodyToMono(String::class.java)
                .block()
            objectMapper.readValue(
                body,
                PokemonDetailDto::class.java
            )
        } catch (ex: WebClientResponseException) {
            if (ex.statusCode === HttpStatus.NOT_FOUND) null
            else throw ex
        }
    }
}