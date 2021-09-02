package com.github.conleyws;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.conleyws.service.PolygonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/polygon")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PolygonController {

    @Autowired
    private PolygonService polygonService;

    @PostMapping("/area")
    @ResponseBody()
    public Double calculateArea(GeoJSON polygon) {
        Double area = 0.0;

        return area;
    }

    @PostMapping("/minBounding")
    public GeoJSON calculateMinBounding(GeoJSON polygon) {
        System.out.println("Polygon: " + polygon.toString());
        return polygonService.calculateMinBounding(polygon);
    }
    
}
