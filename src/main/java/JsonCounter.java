import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author scottalanweber
 */
public class JsonCounter {
  public int countJsonObjects() {
    try {
      byte[] personListFile = Files.readAllBytes(Paths.get(new File("test_resources/person_list.json").toURI()));
      ObjectMapper objectMapper = new ObjectMapper();
      ArrayNode arrayNode = objectMapper.readValue(personListFile, ArrayNode.class);
      return arrayNode.size();
    } catch (IOException e) {
      e.printStackTrace();
      return 0;
    }
  }
}
