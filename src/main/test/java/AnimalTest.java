import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest {

  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("Lion");
    assertEquals(true, testAnimal instanceof Animal);
  }

}