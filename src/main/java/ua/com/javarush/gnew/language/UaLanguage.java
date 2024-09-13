package ua.com.javarush.gnew.language;

import java.util.ArrayList;
import java.util.Set;

public class UaLanguage extends Language {
    public UaLanguage(LanguageCode code, ArrayList<Character> alphabet, Set<String> commonWords) {
        super(code, alphabet, commonWords);
    }

    @Override
    public void test() {
        ArrayList<Character> alphabet = super.getAlphabet();
    }
}

