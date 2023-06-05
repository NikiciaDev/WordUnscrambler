import base.ResultContainer;
import base.Word;
import util.FileUtil;
import util.WordUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class Main {
    private static String scrambled_word;

    public static void main(String[] args) {
        final long start_time = System.nanoTime();
        if(load_words_alpha()) {
            System.out.println("Successfully loaded " + WordUtil.get_words_alpha().length + " words into dictionary in " + ((System.nanoTime() - start_time) / 1e+6) + "ms.");
            System.out.println("To begin enter a scrambled word if you would like to quit simply type \"/f_exit\"!");

            BufferedReader buffered_reader = new BufferedReader(new InputStreamReader(System.in));
            while (!Objects.equals(scrambled_word, "/f_exit")) {
                if (scrambled_word == null) {
                    try {
                        scrambled_word = buffered_reader.readLine();
                    }catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Attempting to unscramble word!");
                    ResultContainer result_container = WordUtil.unscramble_word(new Word(scrambled_word));
                    if(result_container.is_empty()) {
                        System.out.println("Failed to unscrambled word!");
                    }else {
                        System.out.println("Found " + result_container.get_matches().size() + " possible " + (result_container.get_matches().size() == 1 ? "match!" : "matches!"));
                        if(result_container.get_matches().size() != 0) {
                            System.out.println(Arrays.toString(result_container.get_matches().toArray()));
                        }
                        System.out.println("Found " + result_container.get_words_in_scrambled_word().size() + " words inside of the scrambled word!");
                        if(result_container.get_words_in_scrambled_word().size() != 0) {
                            System.out.println(Arrays.toString(result_container.get_words_in_scrambled_word().toArray()));
                        }
                        System.out.println("Ready for the next word!");
                    }
                    scrambled_word = null;
                }
            }
        }else {
            Runtime.getRuntime().exit(-1);
        }
    }

    private static boolean load_words_alpha() {
        try {
            WordUtil.set_words_alpha(FileUtil.load_dictionary_from_file(new File("src/words_alpha.txt")).toArray(new Word[0]));
            return true;
        }catch (IOException e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
        return false;
    }
}
