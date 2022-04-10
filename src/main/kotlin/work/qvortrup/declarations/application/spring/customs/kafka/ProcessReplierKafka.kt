/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.customs.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import work.qvortrup.declarations.application.spring.common.kafka.Topics
import work.qvortrup.declarations.core.controller.processing.ProcessReplier
import work.qvortrup.declarations.core.entity.DeclarationEnvelope

@Component
class ProcessReplierKafka(val out: KafkaTemplate<String, DeclarationEnvelope>, val error: KafkaTemplate<String, DeclarationEnvelope>):
    ProcessReplier {
    override fun onSuccess(envelope: DeclarationEnvelope) {
        out.send(Topics.DECL_OUT, envelope)
    }

    override fun onFailure(envelope: DeclarationEnvelope, errors: List<Throwable>) {
        envelope.errors = errors.toString()
        error.send(Topics.DECL_ERR, envelope)
    }

}