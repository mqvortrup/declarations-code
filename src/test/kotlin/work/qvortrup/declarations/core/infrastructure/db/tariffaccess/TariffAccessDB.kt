/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.infrastructure.db.tariffaccess

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.Tariff
import work.qvortrup.declarations.core.service.enrich.TariffAccess

@Component
class TariffAccessDB : TariffAccess {
    override fun getTariffs(productCodes: List<String>): Map<String, Tariff> {
        return productCodes.associateWith { Tariff(it, 0.05, 0.05) }
    }
}
