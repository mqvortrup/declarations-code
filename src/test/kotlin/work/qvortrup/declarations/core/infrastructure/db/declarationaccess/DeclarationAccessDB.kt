/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.infrastructure.db.declarationaccess

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.Declaration
import work.qvortrup.declarations.core.service.storage.DeclarationAccess

@Component
class DeclarationAccessDB: DeclarationAccess {
    override fun store(declaration: Declaration
    ) {
        println("Storing declaration $declaration")
    }

}