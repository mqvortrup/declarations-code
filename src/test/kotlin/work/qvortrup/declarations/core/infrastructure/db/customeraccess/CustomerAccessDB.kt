/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.infrastructure.db.customeraccess

import work.qvortrup.declarations.core.entity.Customer
import work.qvortrup.declarations.core.service.enrich.CustomerAccess
import work.qvortrup.declarations.core.service.enrich.CustomerNotFound

//@Component
class CustomerAccessDB: CustomerAccess {
    override fun getCustomer(customerCode: String): Customer {
        return when (customerCode) {
            "A Cust" -> Customer("A Cust", "A", "Cust")
            "B Cust" -> Customer("B Cust", "B", "Cust")
            else -> throw CustomerNotFound(customerCode)
        }
    }

}