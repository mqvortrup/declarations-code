/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.customs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.KafkaListener
import work.qvortrup.declarations.application.spring.common.kafka.Topics.Companion.DECL_IN
import work.qvortrup.declarations.core.controller.processing.DeclarationProcessor
import work.qvortrup.declarations.core.entity.DeclarationEnvelope

@SpringBootApplication(scanBasePackages = [
    "work.qvortrup.declarations.application.spring.customs",
    "work.qvortrup.declarations.application.spring.common",
    "work.qvortrup.declarations.core.controller",
    "work.qvortrup.declarations.core.entity",
    "work.qvortrup.declarations.core.service",
    "work.qvortrup.declarations.core.usecase.declare",
])
class Customs(val declarationProcessor: DeclarationProcessor) {

    @KafkaListener(id = "declaration-processor-1", topics = [DECL_IN])
    fun receiveDeclaration(envelope: DeclarationEnvelope?) {
        declarationProcessor.processDeclaration(envelope!!)
    }
}

fun main(args: Array<String>) {
    runApplication<Customs>(*args)
}
