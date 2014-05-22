import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import org.smc.silpamodules.soundex.LanguageConstants;

/**
 * Created by sujith on 19/5/14.
 */
public class TestLanguageConstants extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testLanguageConstants() {
        assertEquals(-1, LanguageConstants.NULL);

        assertEquals(1, LanguageConstants.HINDI);
        assertEquals(2, LanguageConstants.BENGALI);
        assertEquals(3, LanguageConstants.PUNJABI);
        assertEquals(4, LanguageConstants.GUJARATI);
        assertEquals(5, LanguageConstants.ORIYA);
        assertEquals(6, LanguageConstants.TAMIL);
        assertEquals(7, LanguageConstants.TELUGU);
        assertEquals(8, LanguageConstants.KANNADA);
        assertEquals(9, LanguageConstants.MALAYALAM);
        assertEquals(10, LanguageConstants.ENGLISH_US);

        assertEquals(11, LanguageConstants.SOUNDEX_EN);
        assertEquals(12, LanguageConstants.SOUNDEX);
        assertEquals(13, LanguageConstants.SOUNDEX_OLD);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
