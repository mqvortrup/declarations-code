package work.qvortrup.declarations.domain.service.storage

import work.qvortrup.declarations.domain.entity.Declaration

interface Storage {
    fun store(declaration: Declaration)
}
