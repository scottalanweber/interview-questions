package com.sawdevelopment.interview.questions;

import com.sawdevelopment.interview.questions.util.CompressionUtil;

/**
 * @author scottalanweber
 */
public class TfMessageCompression {
  public static void main(String[] args) {
    String stringToCompress = "{\"Messages\": [{" +
        "  \"ChangeAction\": \"CREATE\"," +
        "  \"ChangeType\": \"SOURCE_REFERENCE\"," +
        "  \"EntityId\": \"KDSG-F4C\"," +
        "  \"EntityType\": \"PERSON\"," +
        "  \"JournalEventId\": \"56de3790-bc66-11e8-afc7-d39053cf0f53_0_0\"," +
        "  \"TransactionOperation\": \"ADD_ENTITY_REF\"," +
        "  \"level\": \"INFO\"," +
        "  \"logger_name\": \"org.familysearch.treegraph.common.SQSClientImpl\"," +
        "  \"message\": \"Successful PubSub Message Retrieval\"," +
        "  \"thread\": \"MessageExecutor\"," +
        "  \"timestamp\": \"2018-09-19 23:47:21,877\"" +
        "}]}";
    System.out.println(new String(CompressionUtil.compressAndBase64Encode(stringToCompress, "Something went wrong...")));
  }
}
