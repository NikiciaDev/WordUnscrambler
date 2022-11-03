package util;

import base.Word;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FileUtil {
    public static List<Word> load_dictionary_from_file(final File file) throws IOException {
        if(!file.exists()) throw new FileNotFoundException();

        if(file.getName().endsWith(".txt")) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))){
                final List<Word> dictionary = new ArrayList<>();
                for(String line = br.readLine(); line != null; line = br.readLine()) {
                    dictionary.add(new Word(line));
                    //makes this loop a lot more time-consuming!
                    System.out.println("Successfully added \"" + line + "\" into dictionary!");
                }
                br.close();
                return dictionary;
            }catch(Exception e) {
               throw new IOException("An unexpected error occurred: " + e.getMessage());
            }
        }
        throw new IOException("File Is not a TXT file");
    }
}
