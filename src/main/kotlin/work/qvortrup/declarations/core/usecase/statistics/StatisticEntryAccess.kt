/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.usecase.statistics

import work.qvortrup.declarations.core.entity.ProductStatisticEntry

interface StatisticEntryAccess {

    fun storeEntries(productStatisticEntries: Collection<ProductStatisticEntry>)
}