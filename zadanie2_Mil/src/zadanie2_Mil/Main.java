package zadanie2_Mil;

import java.util.ArrayList;

public class Main {
     public static void main(String [ ] args) {  
    	GUI gui = new GUI();
    	gui.perform();
     }
        
     public static int calculate(ArrayList<Character> data) { 
         ArrayList<Integer> numbers = convertCharToInt(data);
         return amountOfTriangular(numbers);
     }   
     
     static int amountOfTriangular(ArrayList<Integer> numbers) {
         int total = 0;
         for (int l = 0; l < numbers.size(); l++) {
             double tt = (Math.sqrt(1+8*numbers.get(l)) - 1.0) / 2.0;
             if (tt  == (int)tt)
                 total += 1;
         }          
         return total;  
     }
     
     static ArrayList<Integer> convertCharToInt(ArrayList<Character> data) {
         ArrayList<Integer> numbers = new ArrayList<Integer>();
        
         int iter = 0;
         int result = 0;
         while (iter < data.size()) {
             while ((int)data.get(iter) != 44) {
                 result += (int)data.get(iter) - 64; 
                 iter++;
                 if (iter == data.size())
                     break;
             }
             numbers.add(result);
             iter++;
             result = 0;
         }
         return numbers;     
     }
}