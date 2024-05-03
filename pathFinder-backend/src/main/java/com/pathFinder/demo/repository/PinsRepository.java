package com.pathFinder.demo.repository;

import com.pathFinder.demo.domain.entity.Pins;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PinsRepository extends JpaRepository<Pins, Long> {
    List<Pins> findByUser_Userid(Long userId);
}
