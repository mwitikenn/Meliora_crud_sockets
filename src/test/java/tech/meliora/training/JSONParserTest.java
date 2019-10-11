package tech.meliora.training;

import junit.framework.TestCase;
import tech.meliora.training.domain.Operands;
import tech.meliora.training.utils.JSONParser;

/**
 *
 * @author kamochu
 */
public class JSONParserTest extends TestCase {

    public void testParsing() {

        try {
            String jsonString = "{\"operation\":\"add\",\"operand1\":5,\"operand2\":6}";

            Operands operands = JSONParser.parse(jsonString);

            boolean successful = operands.getOperation() == "add" && operands.getA() == 5 && operands.getB() == 6;

            assertTrue(successful);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            assertTrue(false);
        }

    }

}
