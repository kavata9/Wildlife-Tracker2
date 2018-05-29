import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class Sighting {
  private String rangername;
  private String location;
  private int animalid;
  private Timestamp timestamp;
  private int id;

  public Sighting(String rangername, String location, int animalid) {
    this.rangername = rangername;
    this.location = location;
    this.animalid = animalid;
  }

  public String getRangerName() {
    return rangername;
  }

  public String getLocation() {
    return location;
  }

  public int getAnimalId() {
    return animalid;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public int getId() {
    return id;
  }

  public void save() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (rangername, location, animalid, timestamp) VALUES (:rangername, :location, :animalid, now())";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("rangername", this.rangername)
          .addParameter("location", this.location)
          .addParameter("animalid", this.animalid)
          .executeUpdate().getKey();
    }
  }

  @Override
  public boolean equals(Object otherSighting) {
    if (!(otherSighting instanceof Sighting)) {
      return false;
    } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getRangerName().equals(newSighting.getRangerName())
          && this.getLocation().equals(newSighting.getLocation());
    }
  }

  public static List<Sighting> all() {
    String sql = "select * from sightings";
    try (Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Sighting.class);
    }
  }

  public static Sighting find(int id) {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings WHERE id=:id";
      Sighting blog = con.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Sighting.class);
      return blog;
    }
  }

}