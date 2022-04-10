/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.storage.implementation

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import work.qvortrup.declarations.core.service.storage.DeclarationAccess
import work.qvortrup.declarations.core.service.storage.ReceiptAccess
import work.qvortrup.declarations.core.service.storage.Storage

@Component
class StorageImplementation(val declarationAccess: DeclarationAccess, val receiptAccess: ReceiptAccess): Storage {
    override fun store(envelope: DeclarationEnvelope) {
        // decoupling of Customer from Declaration so that Customer is not stored with Declaration
        val customer = envelope.declaration.customer
        envelope.declaration.customer = null
        declarationAccess.store(envelope.declaration)
        // ... and reattach so still available for other users of the Declaration
        envelope.declaration.customer = customer
        receiptAccess.storeReceipts(envelope.receipts!!)
    }
}
