package tech.meliora.training;

import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;
import tech.meliora.training.services.HesabuService;

/**
 *
 * @author kamochu
 */
public class HesabuTest extends TestCase {

    public HesabuTest(String testName) {
        super(testName);
    }

    public void testAdition() {
        assertTrue(new HesabuService().add(5, 6) == 11);
    }

    public void testMultiply() {
        assertTrue(new HesabuService().multiply(5, 6) == 30);
    }

}
