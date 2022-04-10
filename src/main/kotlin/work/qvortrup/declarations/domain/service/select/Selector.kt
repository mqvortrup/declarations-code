package work.qvortrup.declarations.domain.service.select

import work.qvortrup.declarations.domain.entity.Declaration

interface Selector {
    fun select(declaration: Declaration)
}