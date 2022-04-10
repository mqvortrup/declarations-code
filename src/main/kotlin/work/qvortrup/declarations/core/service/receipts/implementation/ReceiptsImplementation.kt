/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.receipts.implementation

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import work.qvortrup.declarations.core.entity.Receipts
import work.qvortrup.declarations.core.service.receipts.Receipts as ReceiptsService

@Component
class ReceiptsImplementation : ReceiptsService {
    override fun createReceipts(envelope: DeclarationEnvelope) {

        envelope.receipts = Receipts(
            envelope.declaration.id,
            "Total customs: ${envelope.declaration.totalDues?.importTax} gummibears \n ${envelope.declaration}",
            "Total VAT: ${envelope.declaration.totalDues?.valueAddedTax} gummibears \n ${envelope.declaration}")
    }
}
