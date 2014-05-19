import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.smc.silpamodules.soundex.Soundex;

/**
 * Created by sujith on 20/5/14.
 */
public class TestSoundex extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testConstructor() {
        Soundex obj = new Soundex();
        assertNotNull(obj);
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testGetModuleName() {
        Soundex obj = new Soundex();
        assertNotNull(obj);

        assertEquals("Soundex", obj.getModuleName());
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testSoundex() {
        Soundex obj = new Soundex();
        assertNotNull(obj);

        assertEquals("കAPKBF00", obj.soundex("കാര്‍ത്തിക്"));
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testCompare() {
        Soundex obj = new Soundex();
        assertNotNull(obj);

        assertEquals(-1, obj.compare("സന്തോഷ്", "സന്തോഷിന്റെ"));
        assertEquals(-1, obj.compare("സന്തോഷ്", "സന്തോഷില്ലേ"));
        assertEquals(-1, obj.compare("പാലക്കാട്", "പാലക്കാടിന്റെ"));
        assertEquals(-1, obj.compare("അടി", "ഇടി"));

        assertEquals(1, obj.compare("streng", "string"));
        assertEquals(1, obj.compare("അധി", "അതി"));
        assertEquals(1, obj.compare("ചക്ക", "ചഗ"));
        assertEquals(1, obj.compare("പ്രതീഷ്", "പ്രദീഷ്"));

        assertEquals(2, obj.compare("പ്രതീഷ്", "ப்ரதீஷ்"));
        assertEquals(2, obj.compare("സന്തോഷ്", "सन्तौष"));

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
