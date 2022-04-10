package work.qvortrup.declarations.domain.service.enrich

import work.qvortrup.declarations.domain.entity.Customer

interface CustomerAccess {
    fun getCustomer(customerCode: String): Customer
}
