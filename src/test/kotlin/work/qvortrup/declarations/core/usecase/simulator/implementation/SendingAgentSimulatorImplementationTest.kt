/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.usecase.simulator.implementation

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import work.qvortrup.declarations.core.usecase.simulator.DeclarationSubmitter

internal class SendingAgentSimulatorImplementationTest {
    @Test
    fun `sufficient unknown customers generated`() {
        val submitterDouble = SubmitterDouble()
        val generator = SendingAgentSimulatorImplementation(submitterDouble)
        generator.generateTestDeclaration(30)
        assertEquals(10, submitterDouble.countOfC)
    }
}

internal class SubmitterDouble : DeclarationSubmitter {
    var countOfC = 0
    override fun submit(declarationEnvelope: DeclarationEnvelope) {
        if (declarationEnvelope.declaration.customerCode == "C Cust") countOfC++
    }
}
