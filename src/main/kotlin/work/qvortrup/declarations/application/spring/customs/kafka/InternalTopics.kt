/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.customs.kafka

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import work.qvortrup.declarations.application.spring.common.kafka.Topics

class InternalTopics {

    @Bean
    fun declarationsIn() = NewTopic(InternalTopics.STAT_IN, 1, 1)

    companion object {
        const val STAT_IN = "statistics-in"
    }
}