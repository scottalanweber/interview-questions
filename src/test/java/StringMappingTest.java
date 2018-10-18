import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.Person;
import util.Record;
import util.RecordSimple;
import util.Relationship;

import java.util.*;

import static org.testng.Assert.*;

/**
 * @author scottalanweber
 */
public class StringMappingTest {
  private StringMapping sut;

  @BeforeMethod
  public void setUp() {
    sut = new StringMapping();
  }

  @Test
  public void testGetInterestingPersons() {
    List<Person> personList = buildPersonList(5);
    List<Record> recordList = buildRecordList(5);

    List<String> personIds = sut.getInterestingPersons(personList, recordList);

    assertNotNull(personIds);
    assertEquals(personIds.size(), 2);
    assertTrue(personIds.contains("PID_0"));
    assertTrue(personIds.contains("PID_1"));
  }

  @Test
  public void testGetInterestingPersonsStream() {
    List<Person> personList = buildPersonList(5);
    List<Record> recordList = buildRecordList(5);

    List<String> personIds = sut.getInterestingPersonsStream(personList, recordList);

    assertNotNull(personIds);
    assertEquals(personIds.size(), 2);
    assertTrue(personIds.contains("PID_0"));
    assertTrue(personIds.contains("PID_1"));
  }

  @Test
  public void testGetInterestingPersonsList() {
    List<Person> personList = buildPersonList(5);
    List<Record> recordList = buildRecordList(5);

    List<Person> persons = sut.getInterestingPersonsList(personList, recordList);

    assertNotNull(persons);
    assertEquals(persons.size(), 2);
    assertEquals(persons.get(0).getId(), "PID_0");
    assertEquals(persons.get(0).getName(), "PERSON_0");
    assertEquals(persons.get(1).getId(), "PID_1");
    assertEquals(persons.get(1).getName(), "PERSON_1");
  }

  @Test
  public void testGetInterestingPersonsMap() {
    List<Person> personList = buildPersonList(5);
    List<Record> recordList = buildRecordList(5);

    Map<String, String> persons = sut.getInterestingPersonsMap(personList, recordList);

    assertNotNull(persons);
    assertEquals(persons.size(), 2);
    assertTrue(persons.containsKey("PID_0"));
    assertEquals(persons.get("PID_0"), "PERSON_0");
    assertTrue(persons.containsKey("PID_1"));
    assertEquals(persons.get("PID_1"), "PERSON_1");
  }

  @Test
  public void testGetInterestingPersonIdsRecordsMap() {
    List<Person> personList = buildPersonList(5);
    List<Record> recordList = buildRecordList(5);

    Map<String, List<Record>> personsRecordMap = sut.getInterestingPersonIdsRecordsMap(personList, recordList);

    assertNotNull(personsRecordMap);
    assertEquals(personsRecordMap.size(), 2);

    assertEquals(personsRecordMap.get("PID_0").size(), 3);
    assertEquals(personsRecordMap.get("PID_0").get(0).getId(), "ID_0");
    assertEquals(personsRecordMap.get("PID_0").get(0).getPersonId(), "PID_0");
    assertEquals(personsRecordMap.get("PID_0").get(1).getId(), "ID_2");
    assertEquals(personsRecordMap.get("PID_0").get(1).getPersonId(), "PID_0");
    assertEquals(personsRecordMap.get("PID_0").get(2).getId(), "ID_4");
    assertEquals(personsRecordMap.get("PID_0").get(2).getPersonId(), "PID_0");

    assertEquals(personsRecordMap.get("PID_1").size(), 2);
    assertEquals(personsRecordMap.get("PID_1").get(0).getId(), "ID_1");
    assertEquals(personsRecordMap.get("PID_1").get(0).getPersonId(), "PID_1");
    assertEquals(personsRecordMap.get("PID_1").get(1).getId(), "ID_3");
    assertEquals(personsRecordMap.get("PID_1").get(1).getPersonId(), "PID_1");
  }

  @Test
  public void testGetInterestingPersonsRecordsMap() {
    List<Person> personList = buildPersonList(5);
    List<Record> recordList = buildRecordList(5);

    Map<Person, List<Record>> personsRecordMap = sut.getInterestingPersonsRecordsMap(personList, recordList);

    assertNotNull(personsRecordMap);
    assertEquals(personsRecordMap.size(), 2);

    assertEquals(personsRecordMap.get(personList.get(0)).size(), 3);
    assertEquals(personsRecordMap.get(personList.get(0)).get(0).getId(), "ID_0");
    assertEquals(personsRecordMap.get(personList.get(0)).get(0).getPersonId(), "PID_0");
    assertEquals(personsRecordMap.get(personList.get(0)).get(1).getId(), "ID_2");
    assertEquals(personsRecordMap.get(personList.get(0)).get(1).getPersonId(), "PID_0");
    assertEquals(personsRecordMap.get(personList.get(0)).get(2).getId(), "ID_4");
    assertEquals(personsRecordMap.get(personList.get(0)).get(2).getPersonId(), "PID_0");

    assertEquals(personsRecordMap.get(personList.get(1)).size(), 2);
    assertEquals(personsRecordMap.get(personList.get(1)).get(0).getId(), "ID_1");
    assertEquals(personsRecordMap.get(personList.get(1)).get(0).getPersonId(), "PID_1");
    assertEquals(personsRecordMap.get(personList.get(1)).get(1).getId(), "ID_3");
    assertEquals(personsRecordMap.get(personList.get(1)).get(1).getPersonId(), "PID_1");
  }

  @Test
  public void testEmptyRecs() {
    List<String> res = sut.getInterestingPersons(new ArrayList<>(), new ArrayList<>());
    assertEquals(res.size(), 0);
  }

  /** ---------------------- INTERVIEWER ---------------------- **/
//  @Test
//  public void testGetInterestingPersons_Interviewer() {
//    List<Person> personList = buildPersonList(5);
//    List<RecordSimple> recordList = buildRecordSimpleList(5);
//
//    List<String> personIds = sut.findPersonIds(personList, recordList);
//
//    assertNotNull(personIds);
//    assertEquals(personIds.size(), 2);
//    assertTrue(personIds.contains("PID_0"));
//    assertTrue(personIds.contains("PID_1"));
//  }
//
//  @Test
//  public void testEmptyRecs_Interviewer() {
//    List<String> res = sut.findPersonIds(new ArrayList<>(), new ArrayList<>());
//    assertEquals(res.size(), 0);
//  }

  /** ---------------------- END OF INTERVIEWER ---------------------- **/

  private List<Person> buildPersonList(int quantity) {
    List<Person> personList = new ArrayList<>();
    for(int i = 0; i < quantity; ++i) {
      Person person = new Person();
      person.setId("PID_" + i);
      person.setName("PERSON_" + i);
      if(i % 2 == 1 && i + 1 < quantity) {
        Relationship spouseRelationship = new Relationship();
        spouseRelationship.setPersonId1(person.getId());
        spouseRelationship.setPersonId2("PID_" + (i + 1));
        person.setSpousalRelationships(Collections.singletonList(spouseRelationship));
      }
      if(i == 3) {
        List<Relationship> childRelationships = new ArrayList<>();
        for(int j = 0; j < 4; ++j) {
          Relationship childRelationship = new Relationship();
          childRelationship.setPersonId1(person.getId());
          childRelationship.setPersonId2("CHILD_" + j);
          childRelationships.add(childRelationship);
        }
        person.setParentChildRelationships(childRelationships);
      }
      personList.add(person);
    }

    return personList;
  }

  private List<Record> buildRecordList(int quantity) {
    List<Record> recordList = new ArrayList<>();
    for(int i = 0; i < quantity; ++i) {
      Record record = new Record();
      record.setId("ID_" + i);
      record.setPersonId("PID_" + (i % 2));
      if(i % 2 == 1 && i + 1 < quantity) {
        Relationship spouseRelationship = new Relationship();
        spouseRelationship.setPersonId1(record.getId());
        spouseRelationship.setPersonId2("ID_" + (i + 1));
        record.setSpousalRelationships(Collections.singletonList(spouseRelationship));
      }
      if(i == 2) {
        List<Relationship> childRelationships = new ArrayList<>();
        for(int j = 0; j < 6; ++j) {
          Relationship childRelationship = new Relationship();
          childRelationship.setPersonId1(record.getId());
          childRelationship.setPersonId2("CHILD_" + j);
          childRelationships.add(childRelationship);
        }
        record.setParentChildRelationships(childRelationships);
      }
      recordList.add(record);
    }

    return recordList;
  }

  private List<RecordSimple> buildRecordSimpleList(int quantity) {
    List<RecordSimple> recordList = new ArrayList<>();
    for(int i = 0; i < quantity; ++i) {
      RecordSimple record = new RecordSimple();
      record.setId("ID_" + i);
      record.setName("NAME_" + i);
      List<String> personIds = new ArrayList<>();
      for(int j = 0; j < quantity / 2; j++) {
        personIds.add("PID_" + j);
      }
      record.setPersonIds(personIds);
      recordList.add(record);
    }

    return recordList;
  }
}