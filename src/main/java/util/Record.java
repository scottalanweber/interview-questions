package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scottalanweber
 */
public class Record {
  private String id;
  private String personId;
  private List<Relationship> spousalRelationships;
  private List<Relationship> parentChildRelationships;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }

  public String getPersonId() { return personId; }
  public void setPersonId(String personId) { this.personId = personId; }

  public List<Relationship> getSpousalRelationships() { return new ArrayList<>(spousalRelationships); }
  public void setSpousalRelationships(List<Relationship> spousalRelationships) { this.spousalRelationships = new ArrayList<>(spousalRelationships); }

  public List<Relationship> getParentChildRelationships() { return new ArrayList<>(parentChildRelationships); }
  public void setParentChildRelationships(List<Relationship> parentChildRelationships) { this.parentChildRelationships = new ArrayList<>(parentChildRelationships); }
}
