package work.qvortrup.declarations.application

import org.jboss.weld.environment.se.Weld

fun main(args: Array<String>) {
    val weld = Weld()
    val container = weld.initialize()

    val app = container.select(AppCreator::class.java).get()
    app.receiver.run()
}