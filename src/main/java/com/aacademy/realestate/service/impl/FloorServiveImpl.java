package com.aacademy.realestate.service.impl;
import com.aacademy.realestate.exception.ResourceNotFoundException;
import com.aacademy.realestate.model.Floor;
import com.aacademy.realestate.repository.FloorRepository;
import com.aacademy.realestate.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
public class FloorServiveImpl implements FloorService {

    private  final FloorRepository floorRepository;

    @Autowired
    public  FloorServiveImpl(FloorRepository floorRepository){
        this.floorRepository = floorRepository;
    }

    @Override
    public Set<Floor> findAll(){
        return new TreeSet<>(floorRepository.findAll());
    }

    @Override
    public Floor save(Floor floor){
        try {
            floorRepository.save(floor);
        }
        catch (DataIntegrityViolationException exception){
            throw new DuplicateResourceException(String.format("Floor with number %d already exist", floor.getNumber()));
        }

    }

    @Override
    public Floor findByNumber(Integer number) {
        return floorRepository.findByNumber((number))
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Floor with number %d does not exist.", number)));
    }

    @Override
    public Floor findById(Long id) {
        return floorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Floor with id %d does not exist.", id)));
    }

    @Override
    public Floor update(Floor floor, Long id) {
        Floor foundFloor = findById(id);
        Floor updatedFloor = Floor.builder()
                .id(foundFloor.getId())
                .number(floor.getNumber())
                .build();
        return save(updatedFloor);
    }

    @Override
    public void delete(Long id) {
        floorRepository.deleteById(id);
    }
}
