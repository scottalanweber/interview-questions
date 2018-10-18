import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author scottalanweber
 */
public class T9MapperTest {
  private T9Mapper sut = new T9Mapper();

  @Test
  public void testMapToWords() throws Exception {
    List<String> output = sut.mapToWords(Arrays.asList(2, 2, 8));

    assertNotNull(output);
    assertEquals(27, output.size());
  }

}