package work.qvortrup.declarations.application

import work.qvortrup.declarations.infrastructure.messaging.receiver.DeclarationReceiver
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class AppCreator @Inject constructor(val receiver: DeclarationReceiver) {

}