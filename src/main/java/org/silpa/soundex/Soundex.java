package org.silpa.soundex;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by sujith on 19/5/14.
 */
public class Soundex {

    /**
     * Module name
     */
    public static final String MODULE_NAME = "Soundex";

    /**
     * Brief information regarding module
     */
    public static final String MODULE_INFORMATION = "Soundex Algorithm for Indian Languages and " +
            "'sounds like' search across Indian Languages";

    // Android Log tag
    private static final String LOG_TAG = "Soundex Module - Soundex";

    /**
     * CharacterMap object
     */
    private CharacterMap characterMap;

    /**
     * Constructor
     */
    public Soundex() {
        this.characterMap = new CharacterMap();
    }

    /**
     * Helper to get Soundex code of the argument passed.
     *
     * @param character single character unicode string
     * @return soundex code of character
     */
    public String soundexCode(String character) {

        if (character == null) throw new NullPointerException();

        try {
            character = new String((character.getBytes("UTF-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(LOG_TAG, "Encoding of given argument not supported. returned null");
            return null;
        }

        int lang = characterMap.language(character);
        HashMap<Integer, List<String>> charmap = characterMap.getCharacterMap();

        try {
            if (lang == CharacterMap.ENGLISH_US) {
                return charmap.get(CharacterMap.SOUNDEX_EN).get(
                        charmap.get(lang).indexOf(character));
            } else {
                return charmap.get(CharacterMap.SOUNDEX).get(
                        charmap.get(lang).indexOf(character));
            }
        } catch (Exception e) {
            return "0";
        }
    }

    /**
     * This function returns Soundex Code of argument passed.
     *
     * @param name unicode string
     * @return soundex code of input in string format
     */
    public String soundex(String name) {
        try {
            name = new String((name.getBytes("UTF-8")), "UTF-8");
        } catch (Exception e) {
            return null;
        }
        int len = 8;
        String sndx = "";
        String fc = "";

        name = name.toLowerCase(Locale.getDefault());

        for (int i = 0; i < name.length(); i++) {
            String c = name.substring(i, i + 1);
            try {
                c = new String((c.getBytes("UTF-8")), "UTF-8");
            } catch (Exception e) {
                return null;
            }

            if ((fc.equals(""))) {
                fc = c;
            }
            String d = soundexCode(c);

            if (d.equals("0"))
                continue;

            if ((sndx.equals(""))
                    || !(d.equals(sndx.charAt(sndx.length() - 1) + ""))) {

                sndx = sndx + d;
            }
        }

        sndx = fc + sndx.substring(1, sndx.length());
        return (sndx + "00000000").substring(0, len);
    }

    /**
     * This functions compares two arguments passed.
     *
     * @param string1 argument1
     * @param string2 argument2
     * @return int
     * 0 - if both arguments are same
     * 1 - if both arguments sound similar and belong to same language
     * 2 - if both arguments sound similar but belong to different language
     * -1 - if arguments dont sound alike or on error
     */
    public int compare(String string1, String string2) {

        if (string1 == null || string2 == null) throw new NullPointerException();

        try {
            string1 = new String((string1.getBytes("UTF-8")), "UTF-8");
            string2 = new String((string2.getBytes("UTF-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(LOG_TAG, "Encoding of given argument not supported. returned -1");
            return -1;
        }

        if (string1.equals(string2)) {
            return 0;
        }

        String soundex1 = soundex(string1);
        String soundex2 = soundex(string2);

        if (soundex1.equals(soundex2)) {
            return 1;
        }

        if (soundexCode(string1.charAt(0) + "").equals(
                soundexCode(string2.charAt(0) + ""))) {
            if ((soundex1.substring(1, soundex1.length())).equals(soundex2
                    .substring(1, soundex2.length()))) {
                return 2;
            }
        }
        return -1;
    }

    /**
     * This function returns module name
     *
     * @return module name
     */
    public String getModuleName() {
        return Soundex.MODULE_NAME;
    }

    /**
     * This function returns module information
     *
     * @return information regarding this module
     */
    public String getModuleInformation() {
        return Soundex.MODULE_INFORMATION;
    }


}
