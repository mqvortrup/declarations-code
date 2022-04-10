/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.common.kafka

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serializer
import work.qvortrup.declarations.core.entity.DeclarationEnvelope
import java.nio.charset.StandardCharsets

class DeclarationSerializer: Serializer<DeclarationEnvelope> {
    private val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create()

    override fun serialize(topic: String?, data: DeclarationEnvelope?): ByteArray? {
        return if (data != null) {
            gson.toJson(data).toByteArray(charset = Charsets.UTF_8)
        } else null
    }
}

class DeclarationDeserializer: Deserializer<DeclarationEnvelope> {
    private val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create()

    override fun deserialize(topic: String?, data: ByteArray?): DeclarationEnvelope? {
        //println(String(data!!, StandardCharsets.UTF_8))
        return if (data != null) {
            gson.fromJson(String(data, StandardCharsets.UTF_8), DeclarationEnvelope::class.java)
        } else null
    }

}