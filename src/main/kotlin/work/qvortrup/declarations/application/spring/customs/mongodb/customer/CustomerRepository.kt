/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.customs.mongodb.customer

import org.springframework.data.mongodb.repository.MongoRepository
import work.qvortrup.declarations.core.entity.Customer

interface CustomerRepository: MongoRepository<Customer, String>