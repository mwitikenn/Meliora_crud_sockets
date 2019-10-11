package tech.meliora.training;

import junit.framework.TestCase;
import tech.meliora.training.utils.FileUtils;

/**
 *
 * @author kamochu
 */
public class FileUtilsTest extends TestCase {

    public void testFileExtension() {
        String resource = "/css/main.css";

        assertTrue("css".equals(FileUtils.getExtension(resource)));

    }

    public void testFileExtensionFileWithDot() {
        String resource = "/css/content.main.css";

        assertTrue("css".equals(FileUtils.getExtension(resource)));

    }

}
