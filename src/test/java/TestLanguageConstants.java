import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import org.silpa.soundex.CharacterMap;

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
        assertEquals(-1, CharacterMap.NULL);

        assertEquals(1, CharacterMap.HINDI);
        assertEquals(2, CharacterMap.BENGALI);
        assertEquals(3, CharacterMap.PUNJABI);
        assertEquals(4, CharacterMap.GUJARATI);
        assertEquals(5, CharacterMap.ORIYA);
        assertEquals(6, CharacterMap.TAMIL);
        assertEquals(7, CharacterMap.TELUGU);
        assertEquals(8, CharacterMap.KANNADA);
        assertEquals(9, CharacterMap.MALAYALAM);
        assertEquals(10, CharacterMap.ENGLISH_US);

        assertEquals(11, CharacterMap.SOUNDEX_EN);
        assertEquals(12, CharacterMap.SOUNDEX);
        assertEquals(13, CharacterMap.SOUNDEX_OLD);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
