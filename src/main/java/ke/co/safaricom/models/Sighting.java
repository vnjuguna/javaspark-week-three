package ke.co.safaricom.models;

import java.time.LocalDateTime;

public class Sighting {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public int getRanger_id() {
        return ranger_id;
    }

    public void setRanger_id(int ranger_id) {
        this.ranger_id = ranger_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }
}