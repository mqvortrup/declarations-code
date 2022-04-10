package work.qvortrup.declarations.domain.service.validate

import work.qvortrup.declarations.domain.entity.Declaration

interface Validator {
    fun validate(declaration: Declaration)
}