/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.customs.mongodb.declaration

import org.springframework.data.mongodb.repository.MongoRepository
import work.qvortrup.declarations.core.entity.Declaration

interface DeclarationRepository : MongoRepository<Declaration, String>