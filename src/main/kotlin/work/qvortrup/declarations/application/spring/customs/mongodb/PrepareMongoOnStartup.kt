/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.customs.mongodb

import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import work.qvortrup.declarations.application.spring.customs.mongodb.customer.CustomerRepository
import work.qvortrup.declarations.application.spring.customs.mongodb.tariff.TariffRepository
import work.qvortrup.declarations.core.entity.Customer
import work.qvortrup.declarations.core.entity.Tariff

@Component
class PrepareMongoOnStartup(val customerRepository: CustomerRepository, val tariffRepository: TariffRepository) : ApplicationListener<ContextRefreshedEvent> {

    private val logger = LoggerFactory.getLogger(PrepareMongoOnStartup::class.java)

    private fun createCustomer(customer: Customer) {
        val c = customerRepository.findById(customer.customerCode)
        if (! c.isPresent) {
            customerRepository.save(customer)
            logger.info("Created $customer")
        } else {
            logger.info("Customer already present $c")
        }
    }

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        listOf(Customer("A Cust", "A", "Cust"), Customer("B Cust", "A", "Cust")).forEach {
            createCustomer(it)
        }
        ('A'..'Z').map {
            Tariff(it.toString(), (it.code - 'A'.code + 1).toDouble(), 2.0 * (it.code - 'A'.code + 1))
        }.forEach {
            createTariff(it)
        }
    }

    private fun createTariff(tariff: Tariff) {
        val t = tariffRepository.findById(tariff.productCode)
        if (! t.isPresent) {
            tariffRepository.save(tariff)
            logger.info("Created $tariff")
        } else {
            logger.info("Tariff already present $t")
        }
    }
}