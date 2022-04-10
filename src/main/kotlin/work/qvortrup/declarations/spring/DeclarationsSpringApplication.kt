package work.qvortrup.declarations.spring

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import work.qvortrup.declarations.controller.async.AsyncDeclaration
import work.qvortrup.declarations.controller.async.AsyncReplier
import work.qvortrup.declarations.domain.entity.Declaration

@SpringBootApplication(scanBasePackages = ["work.qvortrup.declarations"])
class DeclarationsSpringApplication(val asyncDeclaration: AsyncDeclaration) {

    @Bean
    fun declarationsIn() = NewTopic("declarations-in", 1, 1)

    @Bean
    fun declarationsOut() = NewTopic("declarations-out", 1, 1)

    @Bean
    fun declarationsError() = NewTopic("declarations-error", 1, 1)

    @KafkaListener(id = "declaration-processor-1", topics = ["declarations-in"])
    fun receiveDeclaration(value: String?) {
        println(value)
        asyncDeclaration.processDeclaration(Declaration("A Cust"))
    }
}

@Component
class AsyncReplierKafka(val out: KafkaTemplate<Int, String>, val error: KafkaTemplate<Int, String>): AsyncReplier {
    override fun onSuccess(declaration: Declaration) {
        println("On success: $declaration")
        out.send("declarations-out", 0, declaration.toString())
    }

    override fun onFailure(declaration: Declaration, errors: List<Throwable>) {
        println("On error: $declaration")
        error.send("declarations-error", 0, declaration.toString() + errors.toString())
    }

}
fun main(args: Array<String>) {
    runApplication<DeclarationsSpringApplication>(*args)
}
