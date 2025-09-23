# Ported Functions

The following functions have been ported as of version `0.2.0` of this library.

You can view porting progress for the next release [here](https://github.com/maplibre/spatial-k/milestone/1).

## Measurement

- [x] [`along`](../api/turf/org.maplibre.spatialk.turf/along.html)
- [x] [`area`](../api/turf/org.maplibre.spatialk.turf/area.html)
- [x] [`bbox`](../api/turf/org.maplibre.spatialk.turf/bbox.html)
- [x] [`bboxPolygon`](../api/turf/org.maplibre.spatialk.turf/bbox-polygon.html)
- [x] [`bearing`](../api/turf/org.maplibre.spatialk.turf/bearing.html)
- [x] [`center`](../api/turf/org.maplibre.spatialk.turf/center.html)
- [ ] `centerOfMass`
- [x] [`destination`](../api/turf/org.maplibre.spatialk.turf/destination.html)
- [x] [`distance`](../api/turf/org.maplibre.spatialk.turf/distance.html)
- [ ] `envelope`
- [x] [`length`](../api/turf/org.maplibre.spatialk.turf/length.html)
- [x] [`midpoint`](../api/turf/org.maplibre.spatialk.turf/midpoint.html)
- [ ] `pointOnFeature`
- [ ] `polygonTangents`
- [ ] `pointToLineDistance`
- [ ] `rhumbBearing`
- [ ] `rhumbDestination`
- [ ] `rhumbDistance`
- [ ] `square`
- [ ] `greatCircle`

## Coordinate Mutation

- [ ] `cleanCoords`
- [ ] `flip`
- [ ] `rewind`
- [x] `round`
      Use `round` or `Math.round` from the standard library instead.
- [ ] `truncate`

## Transformation

- [ ] `bboxClip`
- [ ] `bezierSpline`
- [ ] `buffer`
- [ ] `circle`
- [ ] `clone`
- [ ] `concave`
- [ ] `convex`
- [ ] `difference`
- [ ] `dissolve`
- [ ] `intersect`
- [ ] `lineOffset`
- [ ] `simplify`
- [ ] `tessellate`
- [ ] `transformRotate`
- [ ] `transformTranslate`
- [ ] `transformScale`
- [ ] `union`
- [ ] `voronoi`

## Feature Conversion

- [ ] `combine`
- [ ] `explode`
- [ ] `flatten`
- [ ] `lineToPolygon`
- [ ] `polygonize`
- [ ] `polygonToLine`

## Miscellaneous

- [ ] `kinks`
- [ ] `lineArc`
- [ ] `lineChunk`
- [x] [`lineIntersect`](../api/turf/org.maplibre.spatialk.turf/line-intersect.html)
      Partially implemented.
- [ ] `lineOverlap`
- [ ] `lineSegment`
- [x] [`lineSlice`](../api/turf/org.maplibre.spatialk.turf/line-slice.html)
- [ ] `lineSliceAlong`
- [ ] `lineSplit`
- [ ] `mask`
- [x] [`nearestPointOnLine`](../api/turf/org.maplibre.spatialk.turf/nearest-point-on-line.html)
- [ ] `sector`
- [ ] `shortestPath`
- [ ] `unkinkPolygon`

## Helper

Use the [GeoJson DSL](../geojson/#geojson-dsl) instead.

## Random

- [ ] `randomPosition`
- [ ] `randomPoint`
- [ ] `randomLineString`
- [ ] `randomPolygon`

## Data

- [ ] `sample`

## Interpolation

- [ ] `interpolate`
- [ ] `isobands`
- [ ] `isolines`
- [ ] `planepoint`
- [ ] `tin`

## Joins

- [ ] `pointsWithinPolygon`
- [ ] `tag`

## Grids

- [ ] `hexGrid`
- [ ] `pointGrid`
- [x] [`squareGrid`](../api/turf/org.maplibre.spatialk.turf/squareGrid.html)
- [ ] `triangleGrid`

## Classification

- [ ] `nearestPoint`

## Aggregation

- [ ] `collect`
- [ ] `clustersDbscan`
- [ ] `clustersKmeans`

## Meta

- [ ] `coordAll`
- [ ] `coordEach`
- [ ] `coordReduce`
- [ ] `featureEach`
- [ ] `featureReduce`
- [ ] `flattenEach`
- [ ] `flattenReduce`
- [ ] `getCoord`
- [ ] `getCoords`
- [ ] `getGeom`
- [ ] `getType`
- [ ] `geomEach`
- [ ] `geomReduce`
- [ ] `propEach`
- [ ] `segmentEach`
- [ ] `segmentReduce`
- [ ] `getCluster`
- [ ] `clusterEach`
- [ ] `clusterReduce`

## Assertations

- [ ] `collectionOf`
- [ ] `containsNumber`
- [ ] `geojsonType`
- [ ] `featureOf`

## Booleans

- [ ] `booleanClockwise`
- [ ] `booleanContains`
- [ ] `booleanCrosses`
- [ ] `booleanDisjoint`
- [ ] `booleanEqual`
- [ ] `booleanOverlap`
- [ ] `booleanParallel`
- [x] [`booleanPointInPolygon`](../api/turf/org.maplibre.spatialk.turf/boolean-point-in-polygon.html)
- [ ] `booleanPointOnLine`
- [ ] `booleanWithin`

## Unit Conversion

- [x] [`bearingToAzimuth`](../api/turf/org.maplibre.spatialk.turf/bearing-to-azimuth.html)
- [x] [`convertArea`](../api/turf/org.maplibre.spatialk.turf/convert-area.html)
- [x] [`convertLength`](../api/turf/org.maplibre.spatialk.turf/convert-length.html)
- [ ] `degreesToRadians`
- [x] [`lengthToRadians`](../api/turf/org.maplibre.spatialk.turf/length-to-radians.html)
- [x] [`lengthToDegrees`](../api/turf/org.maplibre.spatialk.turf/length-to-degrees.html)
- [x] [`radiansToLength`](../api/turf/org.maplibre.spatialk.turf/radians-to-length.html)
- [ ] `radiansToDegrees`
- [ ] `toMercator`
- [ ] `toWgs84`
