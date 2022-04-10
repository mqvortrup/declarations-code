package work.qvortrup.declarations.usecase.declare

import work.qvortrup.declarations.domain.entity.Declaration

interface Declarator {

    fun processDeclaration(declaration: Declaration)
}