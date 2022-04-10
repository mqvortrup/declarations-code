/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.infrastructure.db.receiptaccess

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.Declaration
import work.qvortrup.declarations.core.entity.Receipts
import work.qvortrup.declarations.core.service.storage.ReceiptAccess

@Component
class ReceiptAccessDB: ReceiptAccess {
    override fun storeReceipts(receipts: Receipts) {
        println("Storing receipt: ${receipts.customsReceipt}")
        println("Storing receipt: ${receipts.vatReceipt}")
    }
}