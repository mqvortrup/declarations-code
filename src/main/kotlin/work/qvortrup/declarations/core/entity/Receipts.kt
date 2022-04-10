/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.entity

import org.springframework.data.annotation.Id

class Receipts(@Id var id: Int = 0, val customsReceipt: String, val vatReceipt: String)