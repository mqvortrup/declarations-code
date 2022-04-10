package work.qvortrup.declarations.controller.async

import work.qvortrup.declarations.domain.entity.Declaration

interface AsyncReplier {
    fun onSuccess(declaration: Declaration)
    fun onFailure(declaration: Declaration, errors: List<Throwable>)
}
