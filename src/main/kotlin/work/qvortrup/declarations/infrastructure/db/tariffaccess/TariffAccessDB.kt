package work.qvortrup.declarations.infrastructure.db.tariffaccess

import org.springframework.stereotype.Component
import work.qvortrup.declarations.domain.entity.Tariff
import work.qvortrup.declarations.domain.service.enrich.TariffAccess

@Component
class TariffAccessDB : TariffAccess {
    override fun getTariffs(productCodes: List<String>): Map<String, Tariff> {
        return productCodes.associateWith { Tariff(it, 0.05, 0.05) }
    }
}
