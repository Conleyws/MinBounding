package com.github.conleyws;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
/**    
 *
 * POJO for JSON 
 * 
 * @author wconley
 */
public class GeoJSON {
    String type;
    List<Coordinate> coordinates;


    @JsonCreator
    public GeoJSON(@JsonProperty("type") String type, @JsonProperty("coordinates") List<Coordinate> coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    @JsonGetter("coordinates")
    public List<Coordinate> getCoordinates() {
        return this.coordinates;
    }

    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Type: ").append(this.type);
        builder.append("\nCoordinates: ").append(this.coordinates);
        return builder.toString();
    }

}