/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.entity

class DeclarationEnvelope(val declaration: Declaration) {
    var selectionResult: SelectionResult? = null
    var receipts: Receipts? = null
    var errors: String? = null

    override fun toString(): String {
        return "DeclarationEnvelope(declaration=$declaration, selectionResult=$selectionResult, receipts=$receipts, errors=$errors)"
    }

}