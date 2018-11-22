package com.sawdevelopment.interview.questions.util;

import java.util.List;

/**
 * @author scottalanweber
 */
public class RecordSimple {
  private String id;
  private String name;
  private List<String> personIds;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getPersonIds() {
    return personIds;
  }

  public void setPersonIds(List<String> personIds) {
    this.personIds = personIds;
  }
}
