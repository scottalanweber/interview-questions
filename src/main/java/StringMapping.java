import util.Person;
import util.Record;
import util.RecordSimple;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Questions to Ask
 *
 * 1. Given a list of persons (Person Objects) and a list of records (Record Objects) return a list of PersonIds that are found in the Records
 * 2. Convert some of that code to use Anonymous Functions and Streams
 * 3. How would you adjust the solution if your Product Manager then came and asked you to return the name in addition to the id of person?
 * 4. What if they also wanted the relationships of the person?
 * 5. What if they wanted the PersonId and all of the Records that the person was found in?
 * 6. What if they wanted the Person Object and all of the Records that the person was found in? What would have to be implemented in order for this to work and be testable?
 */


/**
 * Find all persons that exist as the principal person on the record
 * @author scottalanweber
 */
public class StringMapping {
  List<String> getInterestingPersons(List<Person> personList, List<Record> recordList) {
    List<String> personIds = new ArrayList<>();

    for(Person person : personList) {
      int personRecords = 0;
      for(Record record : recordList) {
        if(person.getId().equals(record.getPersonId())) {
          ++personRecords;
        }
      }
      if(personRecords > 0) {
        personIds.add(person.getId());
      }
    }

    return personIds;
  }

  List<String> getInterestingPersonsStream(List<Person> personList, List<Record> recordList) {
    List<String> personIds = new ArrayList<>();

    for(Person person : personList) {
      long personRecords = recordList.stream().filter(r -> person.getId().equals(r.getPersonId())).count();
      if(personRecords > 0) {
        personIds.add(person.getId());
      }
    }

    return personIds;
  }

  List<Person> getInterestingPersonsList(List<Person> personList, List<Record> recordList) {
    List<Person> persons = new ArrayList<>();

    for(Person person : personList) {
      int personRecords = 0;
      for(Record record : recordList) {
        if(person.getId().equals(record.getPersonId())) {
          ++personRecords;
        }
      }
      if(personRecords > 0) {
        persons.add(person);
      }
    }

    return persons;
  }

  Map<String, String> getInterestingPersonsMap(List<Person> personList, List<Record> recordList) {
    Map<String, String> persons = new HashMap<>();

    for(Person person : personList) {
      int personRecords = 0;
      for(Record record : recordList) {
        if(person.getId().equals(record.getPersonId())) {
          ++personRecords;
        }
      }
      if(personRecords > 0) {
        persons.put(person.getId(), person.getName());
      }
    }

    return persons;
  }

  Map<String, List<Record>> getInterestingPersonIdsRecordsMap(List<Person> personList, List<Record> recordList) {
    Map<String, List<Record>> personsRecordMap = new HashMap<>();

    for(Person person : personList) {
      List<Record> personRecords = new ArrayList<>();
      for(Record record : recordList) {
        if(person.getId().equals(record.getPersonId())) {
          personRecords.add(record);
        }
      }
      if(!personRecords.isEmpty()) {
        personsRecordMap.put(person.getId(), personRecords);
      }
    }

    return personsRecordMap;
  }

  Map<Person, List<Record>> getInterestingPersonsRecordsMap(List<Person> personList, List<Record> recordList) {
    Map<Person, List<Record>> personsRecordMap = new HashMap<>();

    for(Person person : personList) {
      List<Record> personRecords = new ArrayList<>();
      for(Record record : recordList) {
        if(person.getId().equals(record.getPersonId())) {
          personRecords.add(record);
        }
      }
      if(!personRecords.isEmpty()) {
        personsRecordMap.put(person, personRecords);
      }
    }

    return personsRecordMap;
  }

  // ------------ Ryan Sheffer (original code was in Javascript ------------
  public Map<Person, List<String>> findPersonIds(List<Person> people, List<RecordSimple> records) {
    Map<Person, List<String>> personRecordNamesMap = new HashMap<>();
    people.stream()
        .filter(p -> records.stream().flatMap(r -> r.getPersonIds().stream()).anyMatch(pId -> pId.equals(p.getId())))
        .collect(Collectors.toMap(p -> p, p -> {
          List<String> recordNames = new ArrayList<>();
          records.forEach(r -> {
            if (r.getPersonIds().contains(p.getId())) {
              recordNames.add(r.getName());
            }
          });
          return recordNames;
        }));
    return personRecordNamesMap;
  }
}
