/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.core.usecase.simulator

interface SendingAgentSimulator {
    fun generateTestDeclaration(count : Int = 100)
}