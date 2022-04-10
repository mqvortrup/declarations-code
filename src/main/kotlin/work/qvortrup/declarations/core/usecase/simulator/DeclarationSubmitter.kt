/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.usecase.simulator

import work.qvortrup.declarations.core.entity.DeclarationEnvelope

interface DeclarationSubmitter {
    fun submit(declarationEnvelope: DeclarationEnvelope)
}
