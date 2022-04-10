/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.service.storage

import work.qvortrup.declarations.core.entity.Declaration

interface DeclarationAccess {
    fun store(declaration: Declaration)
}
