package com.pathFinder.demo.repository;

import com.pathFinder.demo.domain.entity.Pins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PinsRepository extends JpaRepository<Pins, Long> {
}
