/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.calculate.implementation

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import work.qvortrup.declarations.core.entity.Dues
import work.qvortrup.declarations.core.entity.Product
import work.qvortrup.declarations.core.service.calculate.Calculator

@Component
class CalculatorImplementation : Calculator {
    override fun calculate(envelope: DeclarationEnvelope) {
        envelope.declaration.products.forEach { it.dues = calculateDues(it) }
        envelope.declaration.totalDues = envelope.declaration.products.fold(Dues(0.0, 0.0)) {
            total, next -> Dues(total.importTax + next.dues!!.importTax, total.valueAddedTax + next.dues!!.valueAddedTax)
        }
    }

    private fun calculateDues(product: Product): Dues {
        return Dues(
            product.quantity * product.tariff!!.customsRate,
            product.quantity * product.tariff!!.vatRate
        )
    }
}
