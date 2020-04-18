package io.github.dellisd.geojson.serialization

import io.github.dellisd.geojson.BoundingBox
import io.github.dellisd.geojson.Feature
import io.github.dellisd.geojson.Feature.Companion.toFeature
import io.github.dellisd.geojson.LngLat
import io.github.dellisd.geojson.Point
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.JsonLiteral
import kotlin.test.Test
import kotlin.test.assertEquals

@UnstableDefault
@Suppress("MagicNumber")
class FeatureSerializationTests {

    @Test
    fun testSerializeFeature() {
        val geometry = Point(LngLat(12.3, 45.6))
        val feature = Feature(
            geometry, mapOf(
                "size" to JsonLiteral(45.1),
                "name" to JsonLiteral("Nowhere")
            ),
            id = "001",
            bbox = BoundingBox(11.6, 45.1, 12.7, 45.7)
        )

        assertEquals(
            """{"type":"Feature","bbox":[11.6,45.1,12.7,45.7],"geometry":{"type":"Point","coordinates":[12.3,45.6]},
                |"id":"001","properties":{"size":45.1,"name":"Nowhere"}}
            """.trimMargin().replace("\n", ""),
            feature.json
        )
    }

    @Test
    fun testDeserializeFeature() {
        val geometry = Point(LngLat(12.3, 45.6))
        val feature = Feature(
            geometry, mapOf(
                "size" to JsonLiteral(45.1),
                "name" to JsonLiteral("Nowhere")
            ),
            id = "001",
            bbox = BoundingBox(11.6, 45.1, 12.7, 45.7)
        )

        assertEquals(
            feature,
            """{"type":"Feature",
                |"bbox":[11.6,45.1,12.7,45.7],
                |"geometry":{
                    |"type":"Point",
                    |"coordinates":[12.3,45.6]},
                |"id":"001",
                |"properties":{
                    |"size":45.1,
                    |"name":"Nowhere"
                |}}
            """.trimMargin().replace("\n", "").toFeature()
        )
    }
}
