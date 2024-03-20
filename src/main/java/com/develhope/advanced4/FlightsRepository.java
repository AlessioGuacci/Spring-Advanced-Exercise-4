package com.develhope.advanced4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsRepository extends JpaRepository<Flights,Long> {
    List<Flights> findByStatus (Status status);
    List<Flights> findByStatusIn(List<String> status);

}
