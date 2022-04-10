/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.calculate

import work.qvortrup.declarations.core.entity.DeclarationEnvelope

interface Calculator {
    fun calculate(envelope: DeclarationEnvelope)
}