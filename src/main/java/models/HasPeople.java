package models;

import java.util.List;

public interface HasPeople {
    List<Passenger> get();

    void put(Passenger passenger);
}
