/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.controller.processing.implementation

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.controller.processing.DeclarationProcessor
import work.qvortrup.declarations.core.controller.processing.ProcessReplier
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import work.qvortrup.declarations.core.usecase.declare.Declarator

/**
 * This class has the responsibility of collecting  possible errors and replying differently in case of errors
 * in a messaging context.
 */
@Component
class DeclarationProcessorImplementation(val declarator: Declarator, val replier: ProcessReplier) : DeclarationProcessor {

    private var logger = LoggerFactory.getLogger(DeclarationProcessorImplementation::class.java)

    override fun processDeclaration(envelope: DeclarationEnvelope) {
        try {
            logger.info("Processing declaration ${envelope}")
            declarator.processDeclaration(envelope)
            logger.info("Processing succeeded ${envelope}")
            replier.onSuccess(envelope)
        } catch (t : Throwable) {
            logger.error("Processing failed ${envelope}")
            replier.onFailure(envelope, listOf(t))
        }
    }
}