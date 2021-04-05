package com.simsoft.transport.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "routeVehicleController")
@RequestMapping("/api/routeVehicle/*")
@Api(value = "/api/routeVehicle", description = "Route-vehicle APIs Document")
@CrossOrigin
public class RouteVehicleController {
}
