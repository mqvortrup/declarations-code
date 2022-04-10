package work.qvortrup.declarations.infrastructure.messaging.replier

import work.qvortrup.declarations.controller.async.AsyncReplier
import work.qvortrup.declarations.domain.entity.Declaration
import javax.enterprise.context.ApplicationScoped

/**
 * This class would send messages on different queues
 */
@ApplicationScoped
class DeclarationReplierMessaging: AsyncReplier {
    override fun onSuccess(declaration: Declaration) {
        println("Reply onSuccess: $declaration")
        println()
    }

    override fun onFailure(declaration: Declaration, errors: List<Throwable>) {
        println("Reply onFailure: $errors, $declaration")
        println()
    }

}
