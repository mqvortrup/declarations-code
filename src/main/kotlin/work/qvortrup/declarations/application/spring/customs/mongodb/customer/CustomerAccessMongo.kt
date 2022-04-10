/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.customs.mongodb.customer

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.Customer
import work.qvortrup.declarations.core.service.enrich.CustomerAccess
import work.qvortrup.declarations.core.service.enrich.CustomerNotFound

@Component
class CustomerAccessMongo(val repository: CustomerRepository): CustomerAccess {
    override fun getCustomer(customerCode: String): Customer {
        return repository.findById(customerCode).orElseThrow { CustomerNotFound(customerCode) }
    }
}