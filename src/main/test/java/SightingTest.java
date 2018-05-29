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
  public void getRangerName_sightingInstantiatesWithRangerName_Henry() {
    Sighting testSighting = sighting1;
    assertEquals("Henry", testSighting.getRangerName());
  }

  @Test
  public void getLocation_sightingInstantiatesWithLocation_ZoneB() {
    Sighting testSighting = sighting1;
    assertEquals("Zone B", testSighting.getLocation());
  }

  @Test
  public void getAnimalId_sightingnInstantiatesWithAnimalId_1() {
    Sighting testSighting = sighting1;
    assertEquals(1, testSighting.getAnimalId());
  }

  @Test
  public void equals_returnsTrueIfNameAndLocationAreSame_true() {
    Sighting testSighting = sighting1;
    Sighting anotherSighting = sighting1;
    assertTrue(testSighting.equals(anotherSighting));
  }

  @Test
  public void save_insertsObjectIntoDatabase_Sighting() {
    Sighting testSighting = sighting1;
    testSighting.save();
    assertEquals(true, Sighting.all().get(0).equals(testSighting));
  }

  @Test
  public void save_assignsIdToSighting() {
    Sighting testSighting = sighting1;
    testSighting.save();
    Sighting savedSighting = Sighting.all().get(0);
    assertEquals(savedSighting.getId(), testSighting.getId());
  }

  @Test
  public void all_returnsAllInstancesOfSighting_true() {
    Sighting firstSighting = sighting1;
    firstSighting.save();
    Sighting secondSighting = sighting2;
    secondSighting.save();
    assertEquals(true, Sighting.all().get(0).equals(firstSighting));
    assertEquals(true, Sighting.all().get(1).equals(secondSighting));
  }

  @Test
  public void find_returnsSightingWithSameId_secondSighting() {
    Sighting firstSighting = sighting1;
    firstSighting.save();
    Sighting secondSighting = sighting2;
    secondSighting.save();
    assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
  }



}