package io.github.dellisd.spatialk.geojson

import io.github.dellisd.spatialk.geojson.serialization.GeometrySerializer
import kotlin.jvm.JvmStatic
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable(with = GeometrySerializer::class)
public sealed class Geometry protected constructor() : GeoJson {
    abstract override val bbox: BoundingBox?

    override fun toString(): String = json()

    public companion object {
        @JvmStatic
        public fun fromJson(json: String): Geometry =
            fromJson(Json.decodeFromString(JsonObject.serializer(), json))

        @JvmStatic
        public fun fromJsonOrNull(json: String): Geometry? =
            try {
                fromJson(json)
            } catch (_: Exception) {
                null
            }

        @JvmStatic
        public fun fromJson(json: JsonObject): Geometry =
            when (val type = json.getValue("type").jsonPrimitive.content) {
                "Point" -> Point.fromJson(json)
                "MultiPoint" -> MultiPoint.fromJson(json)
                "LineString" -> LineString.fromJson(json)
                "MultiLineString" -> MultiLineString.fromJson(json)
                "Polygon" -> Polygon.fromJson(json)
                "MultiPolygon" -> MultiPolygon.fromJson(json)
                "GeometryCollection" -> GeometryCollection.fromJson(json)
                else -> throw IllegalArgumentException("Unsupported Geometry type \"$type\"")
            }
    }
}
