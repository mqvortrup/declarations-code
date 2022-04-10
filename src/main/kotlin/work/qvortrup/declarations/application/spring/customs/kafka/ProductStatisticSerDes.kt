/*
 * Copyright (c) Michael Qvortrup 2022.
 */

package work.qvortrup.declarations.application.spring.customs.kafka

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serializer
import work.qvortrup.declarations.core.entity.ProductStatisticEntry
import java.nio.charset.StandardCharsets

class ProductStatisticEntrySerializer: Serializer<ProductStatisticEntry> {
    private val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create()

    override fun serialize(topic: String?, data: ProductStatisticEntry?): ByteArray? {
        return if (data != null) {
            gson.toJson(data).toByteArray(charset = Charsets.UTF_8)
        } else null
    }
}

class ProductStatisticEntryDeserializer: Deserializer<ProductStatisticEntry> {
    private val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create()

    override fun deserialize(topic: String?, data: ByteArray?): ProductStatisticEntry? {
        //println(String(data!!, StandardCharsets.UTF_8))
        return if (data != null) {
            gson.fromJson(String(data, StandardCharsets.UTF_8), ProductStatisticEntry::class.java)
        } else null
    }

}