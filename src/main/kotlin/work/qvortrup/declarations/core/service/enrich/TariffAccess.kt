/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.enrich

import work.qvortrup.declarations.core.entity.Tariff

interface TariffAccess {
    fun getTariffs(productCodes: List<String>): Map<String, Tariff>
}
