package work.qvortrup.declarations.domain.service.enrich.implementation

import org.springframework.stereotype.Component
import work.qvortrup.declarations.domain.entity.Declaration
import work.qvortrup.declarations.domain.service.enrich.CustomerAccess
import work.qvortrup.declarations.domain.service.enrich.Enricher
import work.qvortrup.declarations.domain.service.enrich.TariffAccess

@Component
class EnricherImplementation (private val customerAccess: CustomerAccess, private val tariffAccess: TariffAccess) :
    Enricher {
    override fun enrich(declaration: Declaration) {
        val customer = customerAccess.getCustomer(declaration.customerCode)
        declaration.customer = customer
        val productCodes = declaration.products.map { it.productCode }
        val tariffs = tariffAccess.getTariffs(productCodes)
        declaration.products.forEach { it.tariff = tariffs[it.productCode]!! }
    }

}
