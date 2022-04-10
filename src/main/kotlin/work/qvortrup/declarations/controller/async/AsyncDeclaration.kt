package work.qvortrup.declarations.controller.async

import work.qvortrup.declarations.domain.entity.Declaration

interface AsyncDeclaration {
    fun processDeclaration(declaration: Declaration)
}