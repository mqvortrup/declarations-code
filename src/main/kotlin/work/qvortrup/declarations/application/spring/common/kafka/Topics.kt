/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.common.kafka

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean

class Topics {

    @Bean
    fun declarationsIn() = NewTopic(DECL_IN, 1, 1)

    @Bean
    fun declarationsOut() = NewTopic(DECL_OUT, 1, 1)

    @Bean
    fun declarationsError() = NewTopic(DECL_ERR, 1, 1)

    companion object {
        const val DECL_IN = "declarations-in"
        const val DECL_OUT = "declarations-out"
        const val DECL_ERR = "declarations-error"
    }
}