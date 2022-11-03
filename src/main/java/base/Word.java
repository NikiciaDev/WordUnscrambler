package base;

import java.util.Arrays;

public final class Word {
    private final String word;
    private final String sorted_word;

    public Word(String word) {
        this.word = word;
        char[] array = word.toCharArray();
        Arrays.sort(array);
        this.sorted_word = String.valueOf(array);
    }

    public String get_word() {
        return word;
    }

    public String get_sorted_word() {
        return sorted_word;
    }
}
