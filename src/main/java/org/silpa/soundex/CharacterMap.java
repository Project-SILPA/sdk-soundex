package org.silpa.soundex;

import android.annotation.SuppressLint;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CharacterMap {

    public static final int NULL = -1;
    public static final int HINDI = 1;
    public static final int BENGALI = 2;
    public static final int PUNJABI = 3;
    public static final int GUJARATI = 4;
    public static final int ORIYA = 5;
    public static final int TAMIL = 6;
    public static final int TELUGU = 7;
    public static final int KANNADA = 8;
    public static final int MALAYALAM = 9;
    public static final int ENGLISH_US = 10;
    public static final int SOUNDEX_EN = 11;
    public static final int SOUNDEX = 12;
    public static final int SOUNDEX_OLD = 13;

    private static final String LOG_TAG = Soundex.MODULE_NAME;

    /**
     * Character Mapping based on phonetic codes
     */
    private HashMap<Integer, List<String>> characterMap;

    /**
     * Constructor
     */
    @SuppressLint("UseSparseArrays")
    public CharacterMap() {
        characterMap = new HashMap<Integer, List<String>>();
        init();
    }

    /**
     * Initialize characterMap
     */
    private void init() {
        this.characterMap.put(CharacterMap.HINDI, Arrays.asList("ँ", "ं", "ः", "ऄ", "अ", "आ", "इ", "ई", "उ", "ऊ", "ऋ", "ऌ", "ऍ", "ऎ", "ए", "ऐ", "ऑ", "ऒ", "ओ", "औ", "क", "ख", "ग", "घ", "ङ", "च", "छ", "ज", "झ", "ञ", "ट", "ठ", "ड", "ढ", "ण", "त", "थ", "द", "ध", "न", "ऩ", "प", "फ", "ब", "भ", "म", "य", "र", "ऱ", "ल", "ळ", "ऴ", "व", "श", "ष", "स", "ह", "ऺ", "ऻ", "़", "ऽ", "ा", "ि", "ी", "ु", "ू", "ृ", "ॄ", "ॅ", "ॆ", "े", "ै", "ॉ", "ॊ", "ो", "ौ", "्", "ॎ", "ॏ", "ॐ", "॑", "॒", "॓", "॔", "ॕ", "ॖ", "ॗ", "क़", "ख़", "ग़", "ज़", "ड़", "ढ़", "फ़", "य़", "ॠ", "ॡ", "ॢ", "ॣ", "।", "॥", "०", "१", "२", "३", "४", "५", "६", "७", "८", "९", "॰", "ॱ", "ॲ", "ॳ", "ॴ", "ॵ", "ॶ", "ॷ", "ॸ", "ॹ", "ॺ", "ॻ", "ॼ", "ॽ", "ॾ", "ॿ"));
        this.characterMap.put(CharacterMap.BENGALI, Arrays.asList("ঁ", "ং", "ঃ", "঄", "অ", "আ", "ই", "ঈ", "উ", "ঊ", "ঋ", "ঌ", "঍", "঎", "এ", "ঐ", "঑", "঒", "ও", "ঔ", "ক", "খ", "গ", "ঘ", "ঙ", "চ", "ছ", "জ", "ঝ", "ঞ", "ট", "ঠ", "ড", "ঢ", "ণ", "ত", "থ", "দ", "ধ", "ন", "঩", "প", "ফ", "ব", "ভ", "ম", "য", "র", "঱", "ল", "঳", "঴", "঵", "শ", "ষ", "স", "হ", "঺", "঻", "়", "ঽ", "া", "ি", "ী", "ু", "ূ", "ৃ", "ৄ", "৅", "৆", "ে", "ৈ", "৉", "৊", "ো", "ৌ", "্", "ৎ", "৏", "৐", "৑", "৒", "৓", "৔", "৕", "৖", "ৗ", "৘", "৙", "৚", "৛", "ড়", "ঢ়", "৞", "য়", "ৠ", "ৡ", "ৢ", "ৣ", "৤", "৥", "০", "১", "২", "৩", "৪", "৫", "৬", "৭", "৮", "৯", "ৰ", "ৱ", "৲", "৳", "৴", "৵", "৶", "৷", "৸", "৹", "৺", "৻", "ৼ", "৽", "৾", "৿"));
        this.characterMap.put(CharacterMap.PUNJABI, Arrays.asList("ਁ", "ਂ", "ਃ", "਄", "ਅ", "ਆ", "ਇ", "ਈ", "ਉ", "ਊ", "਋", "਌", "਍", "਎", "ਏ", "ਐ", "਑", "਒", "ਓ", "ਔ", "ਕ", "ਖ", "ਗ", "ਘ", "ਙ", "ਚ", "ਛ", "ਜ", "ਝ", "ਞ", "ਟ", "ਠ", "ਡ", "ਢ", "ਣ", "ਤ", "ਥ", "ਦ", "ਧ", "ਨ", "਩", "ਪ", "ਫ", "ਬ", "ਭ", "ਮ", "ਯ", "ਰ", "਱", "ਲ", "ਲ਼", "਴", "ਵ", "ਸ਼", "਷", "ਸ", "ਹ", "਺", "਻", "਼", "਽", "ਾ", "ਿ", "ੀ", "ੁ", "ੂ", "੃", "੄", "੅", "੆", "ੇ", "ੈ", "੉", "੊", "ੋ", "ੌ", "੍", "੎", "੏", "੐", "ੑ", "੒", "੓", "੔", "੕", "੖", "੗", "੘", "ਖ਼", "ਗ਼", "ਜ਼", "ੜ", "੝", "ਫ਼", "੟", "੠", "੡", "੢", "੣", "੤", "੥", "੦", "੧", "੨", "੩", "੪", "੫", "੬", "੭", "੮", "੯", "ੰ", "ੱ", "ੲ", "ੳ", "ੴ", "ੵ", "੶", "੷", "੸", "੹", "੺", "੻", "੼", "੽", "੾", "੿"));
        this.characterMap.put(CharacterMap.GUJARATI, Arrays.asList("ઁ", "ં", "ઃ", "઄", "અ", "આ", "ઇ", "ઈ", "ઉ", "ઊ", "ઋ", "ઌ", "ઍ", "઎", "એ", "ઐ", "ઑ", "઒", "ઓ", "ઔ", "ક", "ખ", "ગ", "ઘ", "ઙ", "ચ", "છ", "જ", "ઝ", "ઞ", "ટ", "ઠ", "ડ", "ઢ", "ણ", "ત", "થ", "દ", "ધ", "ન", "઩", "પ", "ફ", "બ", "ભ", "મ", "ય", "ર", "઱", "લ", "ળ", "઴", "વ", "શ", "ષ", "સ", "હ", "઺", "઻", "઼", "ઽ", "ા", "િ", "ી", "ુ", "ૂ", "ૃ", "ૄ", "ૅ", "૆", "ે", "ૈ", "ૉ", "૊", "ો", "ૌ", "્", "૎", "૏", "ૐ", "૑", "૒", "૓", "૔", "૕", "૖", "૗", "૘", "૙", "૚", "૛", "૜", "૝", "૞", "૟", "ૠ", "ૡ", "ૢ", "ૣ", "૤", "૥", "૦", "૧", "૨", "૩", "૪", "૫", "૬", "૭", "૮", "૯", "૰", "૱", "૲", "૳", "૴", "૵", "૶", "૷", "૸", "ૹ", "ૺ", "ૻ", "ૼ", "૽", "૾", "૿"));
        this.characterMap.put(CharacterMap.ORIYA, Arrays.asList("ଁ", "ଂ", "ଃ", "଄", "ଅ", "ଆ", "ଇ", "ଈ", "ଉ", "ଊ", "ଋ", "ଌ", "଍", "଎", "ଏ", "ଐ", "଑", "଒", "ଓ", "ଔ", "କ", "ଖ", "ଗ", "ଘ", "ଙ", "ଚ", "ଛ", "ଜ", "ଝ", "ଞ", "ଟ", "ଠ", "ଡ", "ଢ", "ଣ", "ତ", "ଥ", "ଦ", "ଧ", "ନ", "଩", "ପ", "ଫ", "ବ", "ଭ", "ମ", "ଯ", "ର", "଱", "ଲ", "ଳ", "଴", "ଵ", "ଶ", "ଷ", "ସ", "ହ", "଺", "଻", "଼", "ଽ", "ା", "ି", "ୀ", "ୁ", "ୂ", "ୃ", "ୄ", "୅", "୆", "େ", "ୈ", "୉", "୊", "ୋ", "ୌ", "୍", "୎", "୏", "୐", "୑", "୒", "୓", "୔", "୕", "ୖ", "ୗ", "୘", "୙", "୚", "୛", "ଡ଼", "ଢ଼", "୞", "ୟ", "ୠ", "ୡ", "ୢ", "ୣ", "୤", "୥", "୦", "୧", "୨", "୩", "୪", "୫", "୬", "୭", "୮", "୯", "୰", "ୱ", "୲", "୳", "୴", "୵", "୶", "୷", "୸", "୹", "୺", "୻", "୼", "୽", "୾", "୿"));
        this.characterMap.put(CharacterMap.TAMIL, Arrays.asList("஁", "ஂ", "ஃ", "஄", "அ", "ஆ", "இ", "ஈ", "உ", "ஊ", "஋", "஌", "஍", "எ", "ஏ", "ஐ", "஑", "ஒ", "ஓ", "ஔ", "க", "஖", "஗", "஘", "ங", "ச", "஛", "ஜ", "஝", "ஞ", "ட", "஠", "஡", "஢", "ண", "த", "஥", "஦", "஧", "ந", "ன", "ப", "஫", "஬", "஭", "ம", "ய", "ர", "ற", "ல", "ள", "ழ", "வ", "ஶ", "ஷ", "ஸ", "ஹ", "஺", "஻", "஼", "஽", "ா", "ி", "ீ", "ு", "ூ", "௃", "௄", "௅", "ெ", "ே", "ை", "௉", "ொ", "ோ", "ௌ", "்", "௎", "௏", "ௐ", "௑", "௒", "௓", "௔", "௕", "௖", "ௗ", "௘", "௙", "௚", "௛", "௜", "௝", "௞", "௟", "௠", "௡", "௢", "௣", "௤", "௥", "௦", "௧", "௨", "௩", "௪", "௫", "௬", "௭", "௮", "௯", "௰", "௱", "௲", "௳", "௴", "௵", "௶", "௷", "௸", "௹", "௺", "௻", "௼", "௽", "௾", "௿"));
        this.characterMap.put(CharacterMap.TELUGU, Arrays.asList("ఁ", "ం", "ః", "ఄ", "అ", "ఆ", "ఇ", "ఈ", "ఉ", "ఊ", "ఋ", "ఌ", "఍", "ఎ", "ఏ", "ఐ", "఑", "ఒ", "ఓ", "ఔ", "క", "ఖ", "గ", "ఘ", "ఙ", "చ", "ఛ", "జ", "ఝ", "ఞ", "ట", "ఠ", "డ", "ఢ", "ణ", "త", "థ", "ద", "ధ", "న", "఩", "ప", "ఫ", "బ", "భ", "మ", "య", "ర", "ఱ", "ల", "ళ", "ఴ", "వ", "శ", "ష", "స", "హ", "఺", "఻", "఼", "ఽ", "ా", "ి", "ీ", "ు", "ూ", "ృ", "ౄ", "౅", "ె", "ే", "ై", "౉", "ొ", "ో", "ౌ", "్", "౎", "౏", "౐", "౑", "౒", "౓", "౔", "ౕ", "ౖ", "౗", "ౘ", "ౙ", "ౚ", "౛", "౜", "ౝ", "౞", "౟", "ౠ", "ౡ", "ౢ", "ౣ", "౤", "౥", "౦", "౧", "౨", "౩", "౪", "౫", "౬", "౭", "౮", "౯", "౰", "౱", "౲", "౳", "౴", "౵", "౶", "౷", "౸", "౹", "౺", "౻", "౼", "౽", "౾", "౿"));
        this.characterMap.put(CharacterMap.KANNADA, Arrays.asList("ಁ", "ಂ", "ಃ", "಄", "ಅ", "ಆ", "ಇ", "ಈ", "ಉ", "ಊ", "ಋ", "ಌ", "಍", "ಎ", "ಏ", "ಐ", "಑", "ಒ", "ಓ", "ಔ", "ಕ", "ಖ", "ಗ", "ಘ", "ಙ", "ಚ", "ಛ", "ಜ", "ಝ", "ಞ", "ಟ", "ಠ", "ಡ", "ಢ", "ಣ", "ತ", "ಥ", "ದ", "ಧ", "ನ", "಩", "ಪ", "ಫ", "ಬ", "ಭ", "ಮ", "ಯ", "ರ", "ಱ", "ಲ", "ಳ", "಴", "ವ", "ಶ", "ಷ", "ಸ", "ಹ", "಺", "಻", "಼", "ಽ", "ಾ", "ಿ", "ೀ", "ು", "ೂ", "ೃ", "ೄ", "೅", "ೆ", "ೇ", "ೈ", "೉", "ೊ", "ೋ", "ೌ", "್", "೎", "೏", "೐", "೑", "೒", "೓", "೔", "ೕ", "ೖ", "೗", "೘", "೙", "೚", "೛", "೜", "ೝ", "ೞ", "೟", "ೠ", "ೡ", "ೢ", "ೣ", "೤", "೥", "೦", "೧", "೨", "೩", "೪", "೫", "೬", "೭", "೮", "೯", "೰", "ೱ", "ೲ", "ೳ", "೴", "೵", "೶", "೷", "೸", "೹", "೺", "೻", "೼", "೽", "೾", "೿"));
        this.characterMap.put(CharacterMap.MALAYALAM, Arrays.asList("ഁ", "ം", "ഃ", "ഄ", "അ", "ആ", "ഇ", "ഈ", "ഉ", "ഊ", "ഋ", "ഌ", "഍", "എ", "ഏ", "ഐ", "഑", "ഒ", "ഓ", "ഔ", "ക", "ഖ", "ഗ", "ഘ", "ങ", "ച", "ഛ", "ജ", "ഝ", "ഞ", "ട", "ഠ", "ഡ", "ഢ", "ണ", "ത", "ഥ", "ദ", "ധ", "ന", "ഩ", "പ", "ഫ", "ബ", "ഭ", "മ", "യ", "ര", "റ", "ല", "ള", "ഴ", "വ", "ശ", "ഷ", "സ", "ഹ", "ഺ", "഻", "഼", "ഽ", "ാ", "ി", "ീ", "ു", "ൂ", "ൃ", "ൄ", "൅", "െ", "േ", "ൈ", "൉", "ൊ", "ോ", "ൌ", "്", "ൎ", "൏", "൐", "൑", "൒", "൓", "ൔ", "ൕ", "ൖ", "ൗ", "൘", "൙", "൚", "൛", "൜", "൝", "൞", "ൟ", "ൠ", "ൡ", "ൢ", "ൣ", "൤", "൥", "൦", "൧", "൨", "൩", "൪", "൫", "൬", "൭", "൮", "൯", "൰", "൱", "൲", "൳", "൴", "൵", "൶", "൷", "൸", "൹", "ൺ", "ൻ", "ർ", "ൽ", "ൾ", "ൿ"));
        this.characterMap.put(CharacterMap.ENGLISH_US, Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
        this.characterMap.put(CharacterMap.SOUNDEX_EN, Arrays.asList("0", "1", "2", "3", "0", "1", "2", "0", "0", "2", "2", "4", "5", "5", "0", "1", "2", "6", "2", "3", "0", "1", "0", "2", "0", "2"));
        this.characterMap.put(CharacterMap.SOUNDEX, Arrays.asList("0", "N", "0", "0", "A", "A", "B", "B", "C", "C", "P", "Q", "0", "D", "D", "D", "E", "E", "E", "E", "F", "F", "F", "F", "G", "H", "H", "H", "H", "G", "I", "I", "I", "I", "J", "K", "K", "K", "K", "L", "L", "M", "M", "M", "M", "N", "O", "P", "P", "Q", "Q", "Q", "R", "S", "S", "S", "T", "0", "0", "0", "0", "A", "B", "B", "C", "C", "P", "P", "E", "D", "D", "D", "D", "E", "E", "E", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "E", "0", "0", "0", "0", "0", "0", "0", "0", "P", "Q", "Q", "Q", "0", "0", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "J", "J", "Q", "P", "P", "F"));
        this.characterMap.put(CharacterMap.SOUNDEX_OLD, Arrays.asList("0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "1", "1", "5", "2", "2", "2", "2", "5", "3", "3", "3", "3", "5", "4", "4", "4", "4", "5", "5", "4", "4", "4", "4", "5", "6", "7", "7", "8", "8", "8", "6", "9", "9", "9", "6", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"));
    }

    /**
     * This getter function returns character map based on phonetic codes
     *
     * @return HashMap<Integer, List<String>>
     * Integer - Language from CharacterMap
     * List<String> - List of character mapping of given language
     */
    public HashMap<Integer, List<String>> getCharacterMap() {
        return this.characterMap;
    }

    /**
     * This function compares two characters based on phonetic codes
     *
     * @param char1 single character unicode string
     * @param char2 single character unicode string
     * @return int
     * 0 - if characters are same
     * 1 - same soundex group index
     * 2 - different soundex group index
     */
    public int charCompare(String char1, String char2) {

        if (char1 == null || char2 == null) throw new NullPointerException();

        try {
            char1 = new String((char1.getBytes("UTF-8")), "UTF-8");
            char2 = new String((char2.getBytes("UTF-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(LOG_TAG, "Encoding of given argument not supported. returned -1");
            return -1;
        }

        if (char1.equals(char2)) return 0;
        int charIndex1 = -1;
        int charIndex2 = -1;

        for (Map.Entry<Integer, List<String>> entry : this.characterMap.entrySet()) {
            Integer lang = entry.getKey();
            for (String letter : this.characterMap.get(lang)) {
                if (letter.equals(char1)) {
                    charIndex1 = this.characterMap.get(lang).indexOf(char1);
                }
            }
        }

        for (Map.Entry<Integer, List<String>> entry : this.characterMap.entrySet()) {
            Integer lang = entry.getKey();
            for (String letter : this.characterMap.get(lang)) {
                if (letter.equals(char2)) {
                    charIndex2 = this.characterMap.get(lang).indexOf(char2);
                }
            }
        }

        if (charIndex1 == -1 || charIndex2 == -1) return -1;
        if (charIndex1 == charIndex2) return 1;

        return -1;
    }

    /**
     * This function determines language of given character input
     *
     * @param character single character unicode string
     * @return int - check CharacterMap
     */
    public int language(String character) {

        if (character == null) throw new NullPointerException();

        try {
            character = new String((character.getBytes("UTF-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(LOG_TAG, "Encoding of given argument not supported. returned -1");
            return CharacterMap.NULL;
        }

        for (Map.Entry<Integer, List<String>> entry : this.characterMap.entrySet()) {
            Integer lang = entry.getKey();
            for (String letter : this.characterMap.get(lang)) {
                if (letter.equals(character)) {
                    Log.i(LOG_TAG, "Language of given argument determined.");
                    return lang.intValue();
                }
            }
        }
        Log.e(LOG_TAG, "Language of given argument could not be determined. returned -1");
        return CharacterMap.NULL;
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
