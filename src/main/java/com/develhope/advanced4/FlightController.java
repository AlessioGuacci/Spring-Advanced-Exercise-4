package com.develhope.advanced4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
   private FlightsRepository flightsRepository;

    @GetMapping("/provisions")
    public List<Flights> flightProvisions (@RequestParam(required = false,defaultValue ="100") int n){
        List<Flights>flightsList= new ArrayList<>();
        Random random =new Random();
        for (int i = 0; i < n; i++){
            Flights flights = new Flights();
            flights.getId();
            flights.setDescription("Flight: " + i);
            flights.setFromAirport("Airport: " + random.nextInt());
            flights.setToAirport("Airport: " + random.nextInt());
            flights.setStatus(Status.ONTIME);
            flightsList.add(flights);
        }
        return flightsList;

    }

    @GetMapping("/allFlights")
    public List<Flights> getAllFlights(){
      return flightsRepository.findAll();
    }

    @GetMapping("/onTime")
    public List<Flights> getAllFlightsOnTime(){
       return flightsRepository.findByStatus(Status.ONTIME);
    }

    @GetMapping("/custom")
    public List<Flights>getCustomFlights(@RequestParam String p1, @RequestParam String p2){
        List<String>customStatus = new ArrayList<>();
        customStatus.add(p1);
        customStatus.add(p2);
        return flightsRepository.findByStatusIn(customStatus);
    }
}
