/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.entity

import org.springframework.data.annotation.Id

data class Customer(@Id val customerCode: String, val firstName: String, val lastName: String)
