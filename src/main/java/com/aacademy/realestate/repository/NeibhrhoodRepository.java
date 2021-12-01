package com.aacademy.realestate.repository;

import com.aacademy.realestate.model.Floor;
import com.aacademy.realestate.model.Neighberhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NeibhrhoodRepository extends  JpaRepository<Neighberhood, Long> {

    Optional<Neighberhood> findByName(String name);
}
