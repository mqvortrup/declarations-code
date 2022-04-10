/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.select.implementation

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import work.qvortrup.declarations.core.entity.SelectionResult
import work.qvortrup.declarations.core.service.select.Selector

@Component
class SelectorImplementation : Selector {
    override fun select(envelope: DeclarationEnvelope) {
        envelope.selectionResult = if (envelope.declaration.products.any { it.productCode == "S" })
            SelectionResult.RED
        else
            SelectionResult.GREEN
    }
}
