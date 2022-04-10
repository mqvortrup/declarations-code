package work.qvortrup.declarations.domain.entity

class Product(val productCode: String, val quantity: Int) {
    var tariff: Tariff? = null
    var dues: Dues? = null

    override fun toString(): String {
        return "Product(productCode='$productCode', quantity=$quantity, tariff=$tariff, dues=$dues)"
    }

}