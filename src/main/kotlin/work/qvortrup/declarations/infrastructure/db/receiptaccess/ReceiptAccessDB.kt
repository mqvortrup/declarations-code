package work.qvortrup.declarations.infrastructure.db.receiptaccess

import org.springframework.stereotype.Component
import work.qvortrup.declarations.domain.service.storage.ReceiptAccess

@Component
class ReceiptAccessDB: ReceiptAccess {
    override fun store(receipt: String) {
        println("Storing receipt: $receipt")
    }
}
