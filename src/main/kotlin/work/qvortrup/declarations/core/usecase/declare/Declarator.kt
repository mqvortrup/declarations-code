/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.usecase.declare

import work.qvortrup.declarations.core.entity.DeclarationEnvelope

interface Declarator {

    fun processDeclaration(envelope: DeclarationEnvelope)
}