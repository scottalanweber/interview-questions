package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author scottalanweber
 */
public class Person {
  private String id;
  private String name;
  private List<Relationship> spousalRelationships;
  private List<Relationship> parentChildRelationships;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public List<Relationship> getSpousalRelationships() { return new ArrayList<>(spousalRelationships); }
  public void setSpousalRelationships(List<Relationship> spousalRelationships) { this.spousalRelationships = new ArrayList<>(spousalRelationships); }

  public List<Relationship> getParentChildRelationships() { return new ArrayList<>(parentChildRelationships); }
  public void setParentChildRelationships(List<Relationship> parentChildRelationships) { this.parentChildRelationships = new ArrayList<>(parentChildRelationships); }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return id.equals(person.id) &&
        name.equals(person.name) &&
        spousalRelationships.equals(person.spousalRelationships) &&
        parentChildRelationships.equals(person.parentChildRelationships);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, spousalRelationships, parentChildRelationships);
  }
}
