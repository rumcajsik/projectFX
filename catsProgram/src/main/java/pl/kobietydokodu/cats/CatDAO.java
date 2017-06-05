package pl.kobietydokodu.cats;

import java.util.ArrayList;
import java.util.List;

import pl.kobietydokodu.cats.domain.Cat;

public class CatDAO {

	List<Cat> cats = new ArrayList<Cat>();
	
	public void addCat(Cat cat) {
		cats.add(cat);
	}
	
	public List<Cat> getCats() {
		return cats;
	}
	
}
