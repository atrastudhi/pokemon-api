package com.sandbox.pokemonapi.pokemon

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

@ConfigurationProperties("app.pokemon")
data class PokemonProperties (
    val uri: String,
)

@Configuration
class PokemonConfiguration {
    @Bean
    fun pokemonWebClient(pokemonProperties: PokemonProperties): WebClient {
        return WebClient
            .builder()
            .baseUrl(pokemonProperties.uri)
            .defaultHeaders {
                it.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            }
            .build()
    }
}