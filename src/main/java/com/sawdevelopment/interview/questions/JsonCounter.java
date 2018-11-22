package com.sawdevelopment.interview.questions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * @author scottalanweber
 */
class JsonCounter {
  int countJsonObjects() {
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
