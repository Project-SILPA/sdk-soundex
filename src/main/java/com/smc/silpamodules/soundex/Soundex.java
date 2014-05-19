package com.smc.silpamodules.soundex;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sujith on 19/5/14.
 */
public class Soundex {

    private static final String LOG_TAG = "Soundex Module - Soundex";

    private CharacterMap characterMap;

    public Soundex() {
        this.characterMap = new CharacterMap();
    }

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
            if (lang == LanguageConstants.ENGLISH_US) {
                return charmap.get(LanguageConstants.SOUNDEX_EN).get(
                        charmap.get(lang).indexOf(character));
            } else {
                return charmap.get(LanguageConstants.SOUNDEX).get(
                        charmap.get(lang).indexOf(character));
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error : " + e.getMessage());
            return "0";
        }
    }

    public String soundex(String name) {

        if (name == null) throw new NullPointerException();

        try {
            name = new String((name.getBytes("UTF-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(LOG_TAG, "Encoding of given argument not supported. returned -1");
            return null;
        }

        int len = 8;
        String sndx = "";
        String fc = "";

        name = name.toLowerCase();

        for (int i = 0; i < name.length(); i++) {
            String c = name.substring(i, i + 1);
            try {
                c = new String((c.getBytes("UTF-8")), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                Log.e(LOG_TAG, "Encoding of given argument not supported. returned -1");
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

    public String getModuleName() {
        return "Soundex";
    }
}
