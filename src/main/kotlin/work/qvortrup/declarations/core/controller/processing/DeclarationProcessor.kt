/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.controller.processing

import work.qvortrup.declarations.core.entity.DeclarationEnvelope

interface DeclarationProcessor {
    fun processDeclaration(envelope: DeclarationEnvelope)
}