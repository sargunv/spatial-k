@file:JvmName("Measurement")
@file:JvmMultifileClass

package org.maplibre.spatialk.turf.measurement

import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmSynthetic
import org.maplibre.spatialk.geojson.*
import org.maplibre.spatialk.units.International.Meters
import org.maplibre.spatialk.units.Length
import org.maplibre.spatialk.units.LengthUnit

/**
 * Calculates the length of the given [Geometry].
 *
 * If the geometry is a [Polygon] or a [MultiPolygon], the length is the perimeter, and holes are
 * included in the length.
 *
 * If the geometry is a [MultiPoint], [MultiLineString], [MultiPolygon], or [GeometryCollection],
 * the length is the sum of the lengths of the individual geometries.
 *
 * @param geometry The geometry to measure
 * @return The length of the geometry
 */
@JvmSynthetic
@JvmName("__length")
public fun length(geometry: Geometry): Length =
    when (geometry) {
        is Point -> Length.Zero
        is MultiPoint -> Length.Zero
        is LineString -> length(geometry.coordinates)
        is MultiLineString ->
            geometry.coordinates.fold(Length.Zero) { acc, coords -> acc + length(coords) }
        is Polygon -> geometry.coordinates.fold(Length.Zero) { acc, ring -> acc + length(ring) }
        is MultiPolygon ->
            geometry.coordinates.fold(Length.Zero) { total, polygon ->
                total + polygon.fold(Length.Zero) { acc, ring -> acc + length(ring) }
            }
        is GeometryCollection ->
            geometry.geometries.fold(Length.Zero) { acc, geom -> acc + length(geom) }
    }

@PublishedApi
@Suppress("unused")
@JvmOverloads
internal fun length(geometry: Geometry, unit: LengthUnit = Meters): Double =
    length(geometry).toDouble(unit)

private fun length(coords: List<Position>): Length {
    var travelled = Length.Zero
    var prevCoords = coords[0]
    for (i in 1 until coords.size) {
        travelled += distance(prevCoords, coords[i])
        prevCoords = coords[i]
    }
    return travelled
}
