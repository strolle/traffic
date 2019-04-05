package it.trolle.traffic.model;

import java.util.*;

public class BusStop {
    private long areaId;
    private String name;

    public BusStop(long areaId, String name) {
        this.areaId = areaId;
        this.name = name;
    }

    public long getAreaId() {
        return areaId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusStop busStop = (BusStop) o;
        return areaId == busStop.areaId &&
                name.equals(busStop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaId, name);
    }

    @Override
    public String toString() {
        return "BusStop{" +
                "areaId=" + areaId +
                ", name='" + name + '\'' +
                '}';
    }
}
