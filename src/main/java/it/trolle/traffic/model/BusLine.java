package it.trolle.traffic.model;

import java.util.*;

public class BusLine {
    private String name;
    private Set<BusStop> busStops;

    public BusLine(String name) {
        this.name = name;
        this.busStops = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<BusStop> getBusStops() {
        return busStops;
    }

    @Override
    public String toString() {
        return "BusLine{" +
                "name='" + name + '\'' +
                ", busStops=(" + busStops.size() + ") " + busStops +
                "}\n";
    }
}
