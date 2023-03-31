package com.sandbox.pokemonapi.pokemon

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pokemon")
class PokemonController(
    private val pokemonService: PokemonService
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getListPokemons(@RequestParam(defaultValue = "0") offset: String, @RequestParam(defaultValue = "10") limit: String): ResponseEntity<*> {
        val result: PokemonDto = pokemonService.getListPokemons(offset, limit)
        return ResponseEntity.ok().body(result)
    }

    @GetMapping("/{pokemonName}")
    @ResponseStatus(HttpStatus.OK)
    fun getDetailPokemon(@PathVariable(value = "pokemonName") pokemonName: String): ResponseEntity<*> {
        val result: PokemonDetailDto? = pokemonService.getDetailPokemon(pokemonName)
        return ResponseEntity.ok().body(result)
    }
}