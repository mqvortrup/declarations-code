package work.qvortrup.declarations.domain.service.enrich

import work.qvortrup.declarations.domain.entity.Tariff

interface TariffAccess {
    fun getTariffs(productCodes: List<String>): Map<String, Tariff>
}
