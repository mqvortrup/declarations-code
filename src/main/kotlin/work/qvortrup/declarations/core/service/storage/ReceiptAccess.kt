/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.storage

import work.qvortrup.declarations.core.entity.Receipts

interface ReceiptAccess {
    fun storeReceipts(receipts: Receipts)
}
