package com.github.conleyws.service;

import java.util.ArrayList;
import java.util.List;

import com.github.conleyws.Coordinate;
import com.github.conleyws.GeoJSON;

import org.springframework.stereotype.Service;

@Service
public class PolygonService {
    
    /**
     * 
     * @param polygon
     * @return GeoJSON - Bounding Shape
     */
    public GeoJSON calculateMinBounding(GeoJSON polygon) {
        // Must not be null and have at least two points
        if (polygon == null || polygon.getCoordinates() == null || polygon.getCoordinates().size() < 3) {
            return polygon;
        }
        
        // 0 = minX
        // 1 = maxY
        // 2 = maxX
        // 3 = minY 
        Double[] bounds = new Double[4];

        // Traverse each coordinate and check if X/Y is new bound
        for (Coordinate coord : polygon.getCoordinates()) {
            // Min X
            if (bounds[0] == null || coord.getX() < bounds[0]) {
                bounds[0] = coord.getX();
            }

            // Max Y
            if (bounds[1] == null || coord.getY() > bounds[1]) {
                bounds[1] = coord.getY();
            }

            // Max X
            if (bounds[2] == null || coord.getX() > bounds[2]) {
                bounds[2] = coord.getX();
            }

            // Min Y
            if (bounds[3] == null || coord.getY() < bounds[3]) {
                bounds[3] = coord.getY();
            }
        }

        List<Coordinate> boundingCoords = new ArrayList<Coordinate>();
        for (int i = 0; i < 5; i++) {
            boundingCoords.add(new Coordinate(bounds[i % 4], bounds[(i+1) % 4]));
        }
        // Assuming starting at Top Left and continuing clockwise
        // MinX MaxY
        // MaxX MaxY
        // MaxX MinY
        // MinX MinY
        // MinX MaxY - Have to return to start


        return new GeoJSON(polygon.getType(), boundingCoords);
    }
}
