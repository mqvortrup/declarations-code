/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.agent.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import work.qvortrup.declarations.application.spring.common.kafka.Topics
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import work.qvortrup.declarations.core.usecase.simulator.DeclarationSubmitter

@Component
class DeclarationSubmitterKafka(val template: KafkaTemplate<String, DeclarationEnvelope>) : DeclarationSubmitter {
    override fun submit(declarationEnvelope: DeclarationEnvelope) {
        template.send(Topics.DECL_IN, declarationEnvelope)
    }
}