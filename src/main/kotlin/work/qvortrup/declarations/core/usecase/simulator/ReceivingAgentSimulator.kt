/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.usecase.simulator

import work.qvortrup.declarations.core.entity.DeclarationEnvelope

interface ReceivingAgentSimulator {
    fun onSuccess(declarationEnvelope: DeclarationEnvelope)
    fun onError(declarationEnvelope: DeclarationEnvelope)
}