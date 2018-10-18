import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

/**
 * @author tom.howell
 */
public class T9Mapper {

  public List<String> mapToWords(List<Integer> inputList) {
    Map<Integer, List<String>> t9Map = new HashMap<>();
    t9Map.put(1, emptyList());
    t9Map.put(2, Arrays.asList("A", "B", "C"));
    t9Map.put(3, Arrays.asList("D", "E", "F"));
    t9Map.put(4, Arrays.asList("G", "H", "I"));
    t9Map.put(5, Arrays.asList("J", "K", "L"));
    t9Map.put(6, Arrays.asList("M", "N", "O"));
    t9Map.put(7, Arrays.asList("P", "Q", "R", "S"));
    t9Map.put(8, Arrays.asList("T", "U", "V"));
    t9Map.put(9, Arrays.asList("W", "X", "Y", "Z"));
    t9Map.put(0, emptyList());

    List<String> resultList = new ArrayList<>();

    resultList.addAll(t9Map.get(inputList.get(0)));

    List<String> tempList = new ArrayList<>();
    for (int i = 1; i < inputList.size(); i++) {
      for (String temp : resultList) {
        for (int j = 0; j < t9Map.get(inputList.get(i)).size(); j++) {
          tempList.add(temp + t9Map.get(inputList.get(i)).get(j));
        }
      }
      resultList.clear();
      resultList.addAll(tempList);
      tempList.clear();
    }

    return resultList;
  }

  public List<String> streamMapToWords(List<Integer> inputList) {
    Map<Integer, List<String>> t9Map = new HashMap<>();
    t9Map.put(1, emptyList());
    t9Map.put(2, Arrays.asList("A", "B", "C"));
    t9Map.put(3, Arrays.asList("D", "E", "F"));
    t9Map.put(4, Arrays.asList("G", "H", "I"));
    t9Map.put(5, Arrays.asList("J", "K", "L"));
    t9Map.put(6, Arrays.asList("M", "N", "O"));
    t9Map.put(7, Arrays.asList("P", "Q", "R", "S"));
    t9Map.put(8, Arrays.asList("T", "U", "V"));
    t9Map.put(9, Arrays.asList("W", "X", "Y", "Z"));
    t9Map.put(0, emptyList());

    List<String> resultList = new ArrayList<>();

    resultList.addAll(t9Map.get(inputList.get(0)));

    List<String> tempList = new ArrayList<>();
    for (int i = 1; i < inputList.size(); i++) {
      for (String temp : resultList) {
        for (int j = 0; j < t9Map.get(inputList.get(i)).size(); j++) {
          tempList.add(temp + t9Map.get(inputList.get(i)).get(j));
        }
      }
      resultList.clear();
      resultList.addAll(tempList);
      tempList.clear();
    }

    return resultList;
  }
}
