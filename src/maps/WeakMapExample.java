package maps;

import java.util.WeakHashMap;

public class WeakMapExample {

	public static void main(String[] args) {

		WeakHashMap<Animal, String> weakHashMap = new WeakHashMap<>();
		weakHashMap.put(new Animal("Dog"), "Pedigree");
		Animal animal = new Animal("Cow");
		weakHashMap.put(animal, "Grass");
		System.out.println("Before gc");
		System.out.println("Map size is " + weakHashMap.size());
		System.gc();
		// Garbage collector collects all the weak reference from the map.
		// Here in this example, Dog is a weak reference because it has not been
		// used any where
		// But cow it has been referenced and not yet removed from memory.
		System.out.println("After running gc");
		System.out.println("Map size is " + weakHashMap.size());

	}

}
