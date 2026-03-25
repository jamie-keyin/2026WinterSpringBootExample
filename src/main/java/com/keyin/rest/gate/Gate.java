package com.keyin.rest.gate;

import com.keyin.rest.airport.Airport;
import jakarta.persistence.*;

@Entity
public class Gate {
    @Id
    @SequenceGenerator(name = "gate_sequence", sequenceName = "gate_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "gate_sequence")
    private Long id;

    private String gateNumber;

    @ManyToOne
    private Airport airport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
