package util;

import base.ResultContainer;
import base.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class WordUtil {
    private static Word[] words_alpha;

    public static ResultContainer unscramble_word(Word scrambled_word) {
        ResultContainer result_container = new ResultContainer();

        for(Word current_word : words_alpha) {
            if(current_word.get_word().length() > scrambled_word.get_word().length()) continue;
            if(current_word.get_word().length() == scrambled_word.get_word().length()) {
                if (Objects.equals(current_word.get_sorted_word(), scrambled_word.get_sorted_word())) {
                    result_container.get_matches().add(current_word.get_word());
                }
            }else {
                if(Objects.equals(current_word.get_sorted_word(), scrambled_word.get_sorted_word().substring(0, current_word.get_sorted_word().length()))) {
                    System.out.println(current_word.get_word());
                    result_container.get_words_in_scrambled_word().add(current_word.get_word());
                }
            }
        }
        return result_container;
    }

    public static Word[] get_words_alpha() {
        return words_alpha;
    }

    public static void set_words_alpha(Word[] words_alpha) {
        WordUtil.words_alpha = words_alpha;
    }
}
