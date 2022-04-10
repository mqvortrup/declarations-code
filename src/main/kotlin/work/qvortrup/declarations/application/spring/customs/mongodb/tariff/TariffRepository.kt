/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.customs.mongodb.tariff

import org.springframework.data.mongodb.repository.MongoRepository
import work.qvortrup.declarations.core.entity.Tariff

interface TariffRepository: MongoRepository<Tariff, String>
