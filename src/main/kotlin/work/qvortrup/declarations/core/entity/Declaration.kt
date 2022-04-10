/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.entity

import org.springframework.data.annotation.Id
import java.util.*

class Declaration(val customerCode: String, val products: List<Product>, val timeStamp: Date = Date()) {
    constructor(customerCode: String, vararg products: Product) : this(customerCode, products.toList())

    @Id
    var id: Int = 0
    var customer: Customer? = null
    var totalDues: Dues? = null

    override fun toString(): String {
        return "Declaration(customerCode='$customerCode', products=$products, id='$id', timeStamp=$timeStamp, customer=$customer, totalDues=$totalDues)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Declaration

        if (customerCode != other.customerCode) return false
        if (products != other.products) return false
        if (timeStamp != other.timeStamp) return false

        return true
    }

    override fun hashCode(): Int {
        var result = customerCode.hashCode()
        result = 31 * result + products.hashCode()
        result = 31 * result + timeStamp.hashCode()
        return result
    }


}