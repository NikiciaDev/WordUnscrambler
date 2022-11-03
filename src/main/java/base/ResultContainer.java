package base;

import java.util.ArrayList;
import java.util.List;

public final class ResultContainer {
    private final List<String> matches;
    private final List<String> words_in_scrambled_word;

    public ResultContainer() {
        this.matches = new ArrayList<>();
        this.words_in_scrambled_word = new ArrayList<>();
    }

    public boolean isEmpty() {
        return matches.isEmpty() && words_in_scrambled_word.isEmpty();
    }

    public List<String> get_matches() {
        return matches;
    }

    public List<String> get_words_in_scrambled_word() {
        return words_in_scrambled_word;
    }
}
