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


#### To run tests
Tests present at `/src/test/java/`

  - Select test to run
  - Right Click -> Run Test -> Run as Android Test


