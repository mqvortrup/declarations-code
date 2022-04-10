/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.enrich.implementation

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.Declaration
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import work.qvortrup.declarations.core.service.enrich.CustomerAccess
import work.qvortrup.declarations.core.service.enrich.BaseDataEnricher
import work.qvortrup.declarations.core.service.enrich.TariffAccess

@Component
class BaseDataEnricherImplementation (private val customerAccess: CustomerAccess, private val tariffAccess: TariffAccess) :
    BaseDataEnricher {
    override fun enrich(envelope: DeclarationEnvelope) {
        envelope.declaration.id = generateId(envelope.declaration)
        val customer = customerAccess.getCustomer(envelope.declaration.customerCode)
        envelope.declaration.customer = customer
        val productCodes = envelope.declaration.products.map { it.productCode }
        val tariffs = tariffAccess.getTariffs(productCodes)
        envelope.declaration.products.forEach { it.tariff = tariffs[it.productCode]!! }
    }

    fun generateId(declaration: Declaration) = declaration.hashCode()
}
