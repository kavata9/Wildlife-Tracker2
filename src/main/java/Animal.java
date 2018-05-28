import org.sql2o.*;

public class Animal {
    public String name;
    public String endangered;
    public int id;

    public Animal(String name, String endangered) {
        this.name = name;
        this.endangered = endangered;
    }

    public String getName() {
        return name;
    }

    public String getEndangered() {
        return endangered;
    }

    @Override

    public boolean equals(Object otherAnimal) {
        if (!(otherAnimal instanceof Animal)) {
            return false;
        } else {
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
          String sql = "INSERT INTO animals (name, endangered) VALUES (:name, :endangered)";
          con.createQuery(sql)
            .addParameter("name", this.name)
            .addParameter("endangered", this.endangered)
            .executeUpdate();
        }
      }
}