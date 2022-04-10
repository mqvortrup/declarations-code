package work.qvortrup.declarations.domain.service.receipts.implementation

import org.springframework.stereotype.Component
import work.qvortrup.declarations.domain.entity.Declaration
import work.qvortrup.declarations.domain.service.receipts.Receipts

@Component
class ReceiptsImplementation : Receipts {
    override fun createReceipts(declaration: Declaration) {
        declaration.customsReceipt = "Total customs: ${declaration.totalDues?.importTax} gummibears"
        declaration.vatReceipt = "Total VAT: ${declaration.totalDues?.valueAddedTax} gummibears"
    }
}
