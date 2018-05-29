import org.sql2o.*;


public class Sighting {
    private String ranger_name;
    private String location;
    private int animal_id;
    // private Timestamp timestamp;
    private int id;
  
    public Sighting (String ranger_name, String location, int animal_id) {
      this.ranger_name = ranger_name;
      this.location = location;
      this.animal_id = animal_id;
    }

    public String getRangerName() {
        return ranger_name;
      }
    
      public String getLocation() {
        return location;
      }

      public int getAnimalId() {
        return animal_id;
      }

      @Override
  public boolean equals(Object otherSighting) {
    if (!(otherSighting instanceof Sighting)) {
      return false;
    } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getRangerName().equals(newSighting.getRangerName()) &&
             this.getLocation().equals(newSighting.getLocation());
    }
  }
    
    
}