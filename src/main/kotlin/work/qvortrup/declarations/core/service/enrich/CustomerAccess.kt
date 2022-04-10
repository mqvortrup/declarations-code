/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.enrich

import work.qvortrup.declarations.core.entity.Customer

interface CustomerAccess {
    fun getCustomer(customerCode: String): Customer
}
