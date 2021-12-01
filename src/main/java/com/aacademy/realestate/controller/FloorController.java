package com.aacademy.realestate.controller;


import com.aacademy.realestate.converter.FloorConverter;
import com.aacademy.realestate.dto.FloorDto;
import com.aacademy.realestate.model.Floor;
import com.aacademy.realestate.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/floors")
public class FloorController {
private final FloorService floorService;
private final FloorConverter

    @Autowired
    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }
    @GetMapping
    public ResponseEntity<Set<FloorDto>> findAll(){
    Set<FloorDto> floorDtos = new HashSet<>();
    Set<Floor> floors = floorService.findAll();

    for(Floor floor: floors){
        FloorDto floorDto = FloorConverter.toFloorDto(floor);
        floorDtos.add(floorDto);
    }

        return ResponseEntity.ok(floorDtos);
    }
}
