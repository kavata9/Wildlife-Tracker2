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
    
}