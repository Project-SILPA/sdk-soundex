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
0 - if both arguments are same
1 - if both arguments sound similar and belong to same language
2 - if both arguments sound similar but belong to different language
-1 - if arguments dont sound alike or on error
```

#### Get Soundex Code of given text 
```
Soundex obj = new Soundex();
String soundexCode = obj.soundex("കാര്‍ത്തിക്");
```
The above function `obj.soundex(String);` accepts a unicode string and returns soundex code of the same.

#### Get Language of string
```
CharacterMap obj = new CharacterMap();
int language = obj.language("अ"); 
```
The above function `obj.language("अ");` accepts a unicode string and returns :
```
1 -  HINDI 
2 -  BENGALI 
3 -  PUNJABI 
4 -  GUJARATI 
5 -  ORIYA 
6 -  TAMIL 
7 -  TELUGU
8 -  KANNADA 
9 -  MALAYALAM 
10 - ENGLISH_US 

// access these via

LanguageConstants.HINDI
LanguageConstants.BENGALI
LanguageConstants.PUNJABI
LanguageConstants.GUJARATI
LanguageConstants.ORIYA
LanguageConstants.TAMIL
LanguageConstants.TELUGU
LanguageConstants.KANNADA
LanguageConstants.MALAYALAM
LanguageConstants.ENGLISH_US
```

#### Get module name and information
```
String moduleName = obj.getModuleName();
String moduleInforamtion =  obj.getModuleInformation();
```

#### To run tests
Tests present at `/src/test/java/`

  - Select test to run
  - Right Click -> Run Test -> Run as Android Test


