package com.sandbox.pokemonapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class PokemonApiApplication

fun main(args: Array<String>) {
	runApplication<PokemonApiApplication>(*args)
}
