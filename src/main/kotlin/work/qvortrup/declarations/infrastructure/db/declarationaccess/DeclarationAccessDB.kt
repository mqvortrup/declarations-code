package work.qvortrup.declarations.infrastructure.db.declarationaccess

import org.springframework.stereotype.Component
import work.qvortrup.declarations.domain.entity.Declaration
import work.qvortrup.declarations.domain.service.storage.DeclarationAccess

@Component
class DeclarationAccessDB: DeclarationAccess {
    override fun store(declaration: Declaration) {
        println("Storing declaration $declaration")
    }

}
