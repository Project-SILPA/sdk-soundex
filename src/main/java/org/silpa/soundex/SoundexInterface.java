package org.silpa.soundex;

/**
 * Created by sujith on 17/6/14.
 */
public interface SoundexInterface {

    /**
     * This function is used to get soundex code from a given view
     *
     * @return soundex code
     */
    public String getSoundexCode();

    /**
     * This function is used to get compare result
     *
     * @return int compare value
     * 0 if both strings are same
     * 1 if strings sound phonetically same
     * 2 if strings are phonetically not same
     */
    public int getCompareValue();
}
