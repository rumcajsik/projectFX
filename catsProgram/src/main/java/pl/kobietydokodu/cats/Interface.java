package pl.kobietydokodu.cats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import pl.kobietydokodu.cats.domain.Cat;

public class Interface {

    static Scanner sc = new Scanner(System.in);
    
    static CatDAO catDao = new CatDAO();

    public static void main(String[] args) {
    	String userChoice;
    	do {
    		System.out.println();
    		System.out.println("Wybierz, co chcesz zrobić, a następnie zatwierdź enterem:");
	    	System.out.println("[1] Dodaj nowego kota");
	    	System.out.println("[2] Pokaż wszystkie koty");
	    	System.out.println("[x] Zakończ");
			userChoice = getUserInput();
	    	if (userChoice.equals("1")) {
	    		addCat();
	    	} else if (userChoice.equals("2")) {
	    		showCats();
	    	}
    	} while (!userChoice.equalsIgnoreCase("x"));
        
    }

	private static void showCats() {
		System.out.println();
		System.out.println("#########################################################");
		System.out.println("######                 LISTA KOTÓW                 ######");
		System.out.println("#########################################################");
		
		Cat cat;
		for (int i=0; i<catDao.getCats().size(); i++) {
			cat = catDao.getCats().get(i);
			System.out.println(i + ": " + cat.getName());
		}
		System.out.println();
		Pattern numberPattern = Pattern.compile("[0-9]+");
		String numberRead;
		do {
			System.out.print("Którego kota chcesz poznać bliżej? ");
			numberRead = getUserInput();
		} while (!numberPattern.matcher(numberRead).matches());
		
		Integer catNumber = Integer.parseInt(numberRead);
		if (catDao.getCats().size()>catNumber) {
			Cat chosenCat = catDao.getCats().get(catNumber);
			System.out.println("Wybrany kot ma na imie "+chosenCat.getName()+", waży "+chosenCat.getWeight()+", urodził się "+chosenCat.getBirthDate().toString()+", a opiekuje się nim "+chosenCat.getOwnerName());
		} else {
			System.out.println("Niestety, nie znalazłem kota o wybranym numerze :( Sprobój ponownie lub go dodaj!");
		}
	}

	private static void addCat() {
		System.out.println();
		System.out.println("#########################################################");
		System.out.println("######                 DODAJ  KOTA                 ######");
		System.out.println("#########################################################");
		Cat cat = new Cat();
		System.out.print("Podaj imię kota: ");
        cat.setName(getUserInput());

        Pattern datePattern = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String birthDateRead;
        do {
            System.out.print("Podaj datę urodzenia kota w formacie RRRR.MM.DD: ");
            birthDateRead = getUserInput();
            if (datePattern.matcher(birthDateRead).matches()) {
            	try {
            		cat.setBirthDate(sdf.parse(birthDateRead));
            	} catch (ParseException pe) {
            		System.out.println("Coś jest nie tak z datą! Przykładowa data: 2014.01.05");
            	}
            }
        } while (cat.getBirthDate()==null);
        
        Pattern weightPattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String weightRead;
        do {
            System.out.print("Podaj wagę kota: ");
            weightRead = getUserInput();
            
            if (weightPattern.matcher(weightRead).matches()) {
                cat.setWeight(Float.valueOf(weightRead));
            }
        } while (cat.getWeight() == null);

        System.out.print("Podaj kto jest opiekunem kota: ");
        cat.setOwnerName(getUserInput());

        catDao.addCat(cat);
        
        System.out.println("Dziękuję, teraz wiem o kocie naprawdę wszystko! Dodałem go do naszego zbioru.");
	}

    public static String getUserInput() {
        return sc.nextLine().trim();
    }

}
