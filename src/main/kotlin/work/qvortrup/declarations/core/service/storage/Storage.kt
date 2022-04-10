/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.storage

import work.qvortrup.declarations.core.entity.DeclarationEnvelope

interface Storage {
    fun store(envelope: DeclarationEnvelope)
}
