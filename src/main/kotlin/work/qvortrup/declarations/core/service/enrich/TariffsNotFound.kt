/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.enrich

class TariffsNotFound(val productCodes: List<String>) : Throwable(productCodes.toString())
