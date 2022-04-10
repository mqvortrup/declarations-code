/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.customs.mongodb.receipt

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.Receipts
import work.qvortrup.declarations.core.service.storage.ReceiptAccess

@Component
class ReceiptAccessMongo(val receiptRepository: ReceiptRepository) : ReceiptAccess {
    override fun storeReceipts(receipts: Receipts) {
        receiptRepository.save(receipts)
    }
}