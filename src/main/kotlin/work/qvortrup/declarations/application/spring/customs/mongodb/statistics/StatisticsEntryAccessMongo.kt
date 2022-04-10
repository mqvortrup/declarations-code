/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.customs.mongodb.statistics

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.ProductStatisticEntry
import work.qvortrup.declarations.core.usecase.statistics.StatisticEntryAccess

@Component
class StatisticsEntryAccessMongo(val statisticsEntryRepository: StatisticsEntryRepository) : StatisticEntryAccess {
    override fun storeEntries(productStatisticEntries: Collection<ProductStatisticEntry>) {
        statisticsEntryRepository.saveAll(productStatisticEntries)
    }
}