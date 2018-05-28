import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest {

  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("Lion");
    assertEquals(true, testAnimal instanceof Animal);
  }

  @Test
  public void getName_animalInstantiatesWithName_Lion() {
    Animal testAnimal = animal1;
    assertEquals("Lion", testAnimal.getName());
  }

  @Test
  public void getEndangered_animalInstantiatesWithEndangered_No() {
    Animal testAnimal = animal1;
    assertEquals("No", testAnimal.getEndangered());
  }

}