/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.select

import work.qvortrup.declarations.core.entity.DeclarationEnvelope

interface Selector {
    fun select(envelope: DeclarationEnvelope)
}