package work.qvortrup.declarations.domain.service.enrich

import work.qvortrup.declarations.domain.entity.Declaration

interface Enricher {
    fun enrich(declaration: Declaration)
}