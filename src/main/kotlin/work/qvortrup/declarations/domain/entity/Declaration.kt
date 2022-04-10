package work.qvortrup.declarations.domain.entity

class Declaration(val customerCode: String, val products: List<Product>) {
    constructor(customerCode: String, vararg products: Product) : this(customerCode, products.toList())

    var customer: Customer? = null
    var totalDues: Dues? = null
    var selectionResult: SelectionResult? = null
    var customsReceipt: String? = null
    var vatReceipt: String? = null

    override fun toString(): String {
        return "Declaration(customerCode='$customerCode', products=$products, customer=$customer, totalDues=$totalDues, selectionResult=$selectionResult, customsReceipt='$customsReceipt', vatReceipt='$vatReceipt')"
    }


}