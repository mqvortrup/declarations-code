/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.entity

import org.springframework.data.annotation.Id

data class Tariff(@Id val productCode: String, val customsRate: Double, val vatRate: Double)
