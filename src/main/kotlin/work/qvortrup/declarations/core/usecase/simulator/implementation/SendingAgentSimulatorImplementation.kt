/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.usecase.simulator.implementation

import org.springframework.stereotype.Component
import work.qvortrup.declarations.core.entity.Declaration
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import work.qvortrup.declarations.core.entity.Product
import work.qvortrup.declarations.core.usecase.simulator.DeclarationSubmitter
import work.qvortrup.declarations.core.usecase.simulator.SendingAgentSimulator

@Component
class SendingAgentSimulatorImplementation(val declarationSubmitter : DeclarationSubmitter) : SendingAgentSimulator {
    override fun generateTestDeclaration(count : Int) {
        (1..count).forEach {
            val declaration = when(it % 3) {
                0 -> Declaration("A Cust", Product("A", it))
                1 -> Declaration("B Cust", Product("1", it))
                else -> Declaration("C Cust", Product("B", it))
            }
            declarationSubmitter.submit(DeclarationEnvelope(declaration))
        }
    }
}