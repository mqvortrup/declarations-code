/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.enrich

import work.qvortrup.declarations.core.entity.DeclarationEnvelope

interface BaseDataEnricher {
    fun enrich(envelope: DeclarationEnvelope)
}