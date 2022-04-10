/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.entity

class Product(val productCode: String, val quantity: Int) {
    var tariff: Tariff? = null
    var dues: Dues? = null

    override fun toString(): String {
        return "Product(productCode='$productCode', quantity=$quantity, tariff=$tariff, dues=$dues)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (productCode != other.productCode) return false
        if (quantity != other.quantity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = productCode.hashCode()
        result = 31 * result + quantity
        return result
    }

}