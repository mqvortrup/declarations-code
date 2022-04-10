/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.validate

import work.qvortrup.declarations.core.entity.DeclarationEnvelope

interface Validator {
    fun validate(envelope: DeclarationEnvelope)
}