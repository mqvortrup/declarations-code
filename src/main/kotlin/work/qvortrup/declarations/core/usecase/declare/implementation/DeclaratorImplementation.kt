/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.usecase.declare.implementation

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import work.qvortrup.declarations.core.service.calculate.Calculator
import work.qvortrup.declarations.core.service.enrich.BaseDataEnricher
import work.qvortrup.declarations.core.service.receipts.Receipts
import work.qvortrup.declarations.core.service.select.Selector
import work.qvortrup.declarations.core.service.storage.Storage
import work.qvortrup.declarations.core.service.validate.Validator
import work.qvortrup.declarations.core.usecase.declare.Declarator

/**
 * The only responsibility of this class is to process the declaration according to the business rules
 */
@Component
class DeclaratorImplementation(val basedataEnricher: BaseDataEnricher, val validator: Validator, val selector: Selector, val calculator: Calculator, val receipts: Receipts, val storage: Storage):
    Declarator {

    override fun processDeclaration(envelope: DeclarationEnvelope) {
        basedataEnricher.enrich(envelope)
        validator.validate(envelope)
        calculator.calculate(envelope)
        selector.select(envelope)
        receipts.createReceipts(envelope)
        storage.store(envelope)
    }
}