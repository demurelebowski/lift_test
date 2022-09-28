package models;

import java.util.List;

public interface HasPeople {
    List<Passenger> getPeople();

    void putPeople(Passenger passenger);

    int getMaxDesiredFloor();
}
