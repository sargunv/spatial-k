@file:JvmName("Measurement")
@file:JvmMultifileClass

package org.maplibre.spatialk.turf.measurement

import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmSynthetic
import org.maplibre.spatialk.geojson.LineString
import org.maplibre.spatialk.geojson.Position
import org.maplibre.spatialk.units.International.Meters
import org.maplibre.spatialk.units.Length
import org.maplibre.spatialk.units.LengthUnit
import org.maplibre.spatialk.units.extensions.toLength

/**
 * Takes a [LineString] and returns a [position][Position] at a specified distance along the line.
 *
 * @param line input line
 * @param distance distance along the line
 * @return A position [distance] along the line
 */
@JvmSynthetic
public fun along(line: LineString, distance: Length): Position {
    var travelled = Length.Zero

    line.coordinates.forEachIndexed { i, coordinate ->
        when {
            distance >= travelled && i == line.coordinates.size - 1 -> {}
            travelled >= distance -> {
                val overshot = distance - travelled
                return if (overshot.isZero) coordinate
                else {
                    val direction = bearing(coordinate, line.coordinates[i - 1]) - 180
                    destination(coordinate, overshot, direction)
                }
            }

            else -> travelled += distance(coordinate, line.coordinates[i + 1])
        }
    }

    return line.coordinates[line.coordinates.size - 1]
}

@PublishedApi
@Suppress("unused")
@JvmOverloads
internal fun along(line: LineString, distance: Double, unit: LengthUnit = Meters): Position =
    along(line, distance.toLength(unit))
