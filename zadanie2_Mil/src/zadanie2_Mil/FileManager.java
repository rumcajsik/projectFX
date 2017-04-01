package zadanie2_Mil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class FileManager {
	
	static ArrayList<Character> loadData(String fileName) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(fileName)));
        
        return parseData(contents);
	}
	
	static ArrayList<Character> parseData(String contents) {
		
		ArrayList<Character> data = new ArrayList<Character>();	
		
		// string to char convertion
        for (char c : contents.toCharArray())
          data.add(c);
        
        // parsing file: "" removal
        for (int i = 0; i < data.size(); i++) {
       	 if ((int)data.get(i) == 34)
       		 data.remove(i);
        }
        
        return data;
        
	}
}