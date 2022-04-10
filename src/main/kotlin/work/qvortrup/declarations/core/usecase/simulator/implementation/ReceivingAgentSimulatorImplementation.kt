/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.usecase.simulator.implementation

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import work.qvortrup.declarations.core.usecase.simulator.ReceivingAgentSimulator

@Component
class ReceivingAgentSimulatorImplementation : ReceivingAgentSimulator {
    private val logger = LoggerFactory.getLogger(ReceivingAgentSimulatorImplementation::class.java)

    override fun onSuccess(declarationEnvelope: DeclarationEnvelope) {
        logger.info("Declaration succeeded $declarationEnvelope")
    }

    override fun onError(declarationEnvelope: DeclarationEnvelope) {
        logger.error("Declaration failed $declarationEnvelope")
    }
}