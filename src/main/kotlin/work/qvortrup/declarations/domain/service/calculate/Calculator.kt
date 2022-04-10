package work.qvortrup.declarations.domain.service.calculate

import work.qvortrup.declarations.domain.entity.Declaration

interface Calculator {
    fun calculate(declaration: Declaration)
}