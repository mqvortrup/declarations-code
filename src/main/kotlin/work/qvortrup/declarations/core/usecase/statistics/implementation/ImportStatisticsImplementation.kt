/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.usecase.statistics.implementation

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.Declaration
import work.qvortrup.declarations.core.entity.ProductStatisticEntry
import work.qvortrup.declarations.core.usecase.statistics.ImportStatistics
import work.qvortrup.declarations.core.usecase.statistics.StatisticEntryAccess

@Component
class ImportStatisticsImplementation(val statisticEntryAccess: StatisticEntryAccess): ImportStatistics {

    override fun updateImportStatistics(declaration: Declaration) {
        val statisticEntries = extractAndSumProductQuantities(declaration)
        statisticEntryAccess.storeEntries(statisticEntries)
    }

    private fun extractAndSumProductQuantities(declaration: Declaration): Collection<ProductStatisticEntry> {
        return declaration.products
            .groupBy { it.productCode }
            .map { ProductStatisticEntry(declaration.timeStamp, it.key, it.value.sumOf { product -> product.quantity })}
    }
}