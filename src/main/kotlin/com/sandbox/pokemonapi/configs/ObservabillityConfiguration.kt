package com.sandbox.pokemonapi.configs

import io.micrometer.observation.Observation
import io.micrometer.observation.Observation.Context
import io.micrometer.observation.ObservationHandler
import io.micrometer.observation.ObservationRegistry
import io.micrometer.observation.aop.ObservedAspect
import mu.KotlinLogging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
class LogginObservationHandler: ObservationHandler<Observation.Context> {
    private val logger = KotlinLogging.logger() {}

    override fun supportsContext(context: Context): Boolean {
        return true
    }

    override fun onStart(context: Context) {
        logger.debug { ">> Entering ${context.name} <<" }
        context.put("time", System.currentTimeMillis())
    }

    override fun onStop(context: Context) {
        val processTime = System.currentTimeMillis() - (context.get<Long>("time") ?: 0)
        logger.debug { ">> Exiting ${context.name} | Process Time: $processTime <<" }
    }

    override fun onError(context: Context) {
        logger.error(context.error) { "!! ${context.error?.message} !!" }
    }
}

@Configuration
class ObservedAspectConfiguration {
    @Bean
    fun observedAspect(observationRegistry: ObservationRegistry): ObservedAspect {
        return ObservedAspect(observationRegistry)
    }
}