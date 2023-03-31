package com.sandbox.pokemonapi.pokemon

data class PokemonDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResults>,
)

data class PokemonResults(
    val name: String,
    val url: String,
)

data class PokemonDetailDto(
    val abilities: List<*>?,
    val base_experience: Int?,
    val forms: List<*>?,
    val game_indices: List<*>?,
    val height: Int?,
    val held_items: List<*>?,
    val id: Int?,
    val is_default: Boolean?,
    val location_area_encounters: String?,
    val moves: List<*>?,
    val name: String?,
    val order: Int?,
    val past_type: List<*>?,
    val species: PokemonResults?,
    val sprites: DetailSprites?,
    val stats: List<*>?,
    val type: List<*>?,
)

data class DetailSprites(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?,
    val other: Any,
)