/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.validate.implementation

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import work.qvortrup.declarations.core.service.validate.ValidationError
import work.qvortrup.declarations.core.service.validate.Validator

@Component
class ValidatorImplementation : Validator {
    override fun validate(envelope: DeclarationEnvelope) {
        envelope.declaration.products.forEach {
            if (it.quantity <= 0.0) throw ValidationError("Quantity of $it must not be zero")
        }
    }

}
