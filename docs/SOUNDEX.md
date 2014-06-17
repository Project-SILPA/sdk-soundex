Usage
=====

### Note :
This module is still under development and this document presently shows only currently available utilities.

#### Comparing two texts 
```
        Soundex obj = new Soundex();
        int result = obj.compare("ಬೆಂಗಳೂರು", "बॆंगळूरु");
```
The above function `obj.compare(String, String);` accepts two unicode strings to be compared and returns : 

```
        0 - if both strings are same
        1 - if strings sound phonetically same
        2 - if strings are phonetically not same
        -1 - if on English cross language comparison or on error  
```

#### Get Soundex Code of given text 
```
        Soundex obj = new Soundex();
        String soundexCode = obj.soundex("കാര്‍ത്തിക്");
```
The above function `obj.soundex(String);` accepts a unicode string and returns soundex code of the same.

#### SoundexEditText

```

        <org.silpa.soundex.SoundexEditText
                android:id="@+id/edtSoundex"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                soundex:soundexCompareWith="@+id/edtCompareSoundex"
                soundex:soundexCodeOutputTo="@+id/tvSoundexCode" />

```

Here `soundex:soundexCompareWith` value can be an EditText or TextView and soundex will use that field to compare value and is done dynamically ie. as you type.

`soundex:soundexCodeOutputTo` would dynamically output soundex code to another Edit text or text view.

These values can also be set from Java by :

```
        SoundexEditText edtSoundex = (SoundexEditText) view.findViewById(R.id.edtSoundex);
        edtSoundex.setCompareWithResourceId(R.id.edtCompareSoundex);
        edtSoundex.setSoundexCodeResourceId(R.id.tvSoundexCode);
```

Results can also be obtained from Java by :

```        
        int cmp = edtSoundex.getCompareValue();
        String soundexCode = edtSoundex.getSoundexCode();
```


#### SoundexTextView

```

        <org.silpa.soundex.SoundexTextView
                android:id="@+id/tvSoundex"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                soundex:soundexCompareWith="@+id/edtSoundex"/>

```

Here `soundex:soundexCompareWith` value can be an EditText or TextView and soundex will use that field to compare value.

These values can also be set from Java by :

```
        SoundexTextView tvSoundex = (SoundexTextView) view.findViewById(R.id.tvSoundex);
        tvSoundex.setCompareWithResourceId(R.id.edtOther);
```

Results can be obtained from Java by :

```        
        int cmp = tvSoundex.getCompareValue();
        String soundexCode = tvSoundex.getSoundexCode();
```


#### To run tests
Tests present at `/src/test/java/`

  - Select test to run
  - Right Click -> Run Test -> Run as Android Test


