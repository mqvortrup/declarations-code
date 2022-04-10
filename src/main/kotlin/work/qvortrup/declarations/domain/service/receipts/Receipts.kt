package work.qvortrup.declarations.domain.service.receipts

import work.qvortrup.declarations.domain.entity.Declaration

interface Receipts {
    fun createReceipts(declaration: Declaration)
}