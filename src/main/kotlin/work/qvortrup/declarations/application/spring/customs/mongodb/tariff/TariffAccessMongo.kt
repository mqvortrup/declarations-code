/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.customs.mongodb.tariff

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.Tariff
import work.qvortrup.declarations.core.service.enrich.TariffAccess
import work.qvortrup.declarations.core.service.enrich.TariffsNotFound

@Component
class TariffAccessMongo(val repository: TariffRepository): TariffAccess {
    override fun getTariffs(productCodes: List<String>): Map<String, Tariff> {
        val tariffs = repository.findAllById(productCodes).associateBy { it.productCode }
        if (tariffs.size != productCodes.size) {
            throw TariffsNotFound(productCodes.toSet().subtract(tariffs.keys).toList())
        } else {
            return tariffs
        }
    }
}
