import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class SightingTest {

@Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void sighting_instantiatesCorrectly_true() {
    Sighting testSighting = sighting1;
    assertEquals(true, testSighting instanceof Sighting);
  }

  @Test
  public void getRangerName_personInstantiatesWithRangerName_Henry() {
    Sighting testSighting = sighting1;
    assertEquals("Henry", testSighting.getRangerName());
  }

  @Test
  public void getLocation_personInstantiatesWithLocation_ZoneB() {
    Sighting testSighting = sighting1;
    assertEquals("Zone B", testSighting.getLocation());
  }

}