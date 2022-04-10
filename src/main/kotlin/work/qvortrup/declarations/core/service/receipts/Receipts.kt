/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.receipts

import work.qvortrup.declarations.core.entity.DeclarationEnvelope

interface Receipts {
    fun createReceipts(envelope: DeclarationEnvelope)
}