/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.customs.mongodb.declaration

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.Declaration
import work.qvortrup.declarations.core.service.storage.DeclarationAccess
import java.util.*

@Component
class DeclarationAccessMongo(val repository: DeclarationRepository) : DeclarationAccess {
    override fun store(declaration: Declaration) {
        repository.save(declaration)
    }
}