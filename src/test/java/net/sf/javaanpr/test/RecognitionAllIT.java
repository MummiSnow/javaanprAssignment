package net.sf.javaanpr.test;

import net.sf.javaanpr.imageanalysis.CarSnapshot;
import net.sf.javaanpr.intelligence.Intelligence;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RecognitionAllIT {
    private static final String snapshotsPath = "src/test/resources/snapshots";
    private static final String resultsPath = "src/test/resources/results.properties";
    private static Intelligence logic;
    private String expected;
    private File file;


    public RecognitionAllIT(File file, String expected) {
        this.file = file;
        this.expected = expected;
    }

    @BeforeClass
    public static void initialize() throws ParserConfigurationException, SAXException, IOException {
        logic = new Intelligence();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testAllSnapshots() throws IOException, FileNotFoundException {
        InputStream resultsStream = new FileInputStream(new File(resultsPath));

        Properties properties = new Properties();
        properties.load(resultsStream);
        resultsStream.close();
        assertTrue(properties.size() > 0);
        File snapshotDir = new File(snapshotsPath);
        File[] snapshots = snapshotDir.listFiles();
        assertNotNull(snapshots);
        assertTrue(snapshots.length > 0);


        Collection<Object[]> dataForOneImage = new ArrayList();
        for (File file : snapshots) {
            String name = file.getName();
            String correctPlate = properties.getProperty(name);
            dataForOneImage.add(new Object[]{file, correctPlate});
        }
        return dataForOneImage;
    }

    @Test
    public void recogniseSingleImage() throws FileNotFoundException, IOException {
        CarSnapshot carSnap = new CarSnapshot(new FileInputStream(file)); // snapshotsPath + "/" + file.getName()
        assertThat(expected, is(logic.recognize(carSnap)));
    }


}