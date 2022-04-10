/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.agent

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import work.qvortrup.declarations.application.spring.common.kafka.Topics.Companion.DECL_ERR
import work.qvortrup.declarations.application.spring.common.kafka.Topics.Companion.DECL_OUT
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import work.qvortrup.declarations.core.usecase.simulator.ReceivingAgentSimulator
import work.qvortrup.declarations.core.usecase.simulator.SendingAgentSimulator

@SpringBootApplication(scanBasePackages = [
    "work.qvortrup.declarations.application.spring.agent",
    "work.qvortrup.declarations.application.spring.common",
    "work.qvortrup.declarations.core.usecase.simulator",
    "work.qvortrup.declarations.core.entity"])
class Agent(val sendingAgentSimulator: SendingAgentSimulator, val receivingAgentSimulator: ReceivingAgentSimulator) {

    @Bean
    fun agentRunner(template: KafkaTemplate<String, DeclarationEnvelope>) = ApplicationRunner {
        sendingAgentSimulator.generateTestDeclaration()
    }

    @KafkaListener(id = "declared-processor-1", topics = [DECL_OUT])
    fun receiveDeclaration(declarationEnvelope: DeclarationEnvelope?) {
        receivingAgentSimulator.onSuccess(declarationEnvelope!!)
    }

    @KafkaListener(id = "declared-processor-error-1", topics = [DECL_ERR])
    fun receiveDeclarationError(declarationEnvelope: DeclarationEnvelope?) {
        receivingAgentSimulator.onError(declarationEnvelope!!)
    }
}

fun main(args: Array<String>) {
    runApplication<Agent>(*args)
}