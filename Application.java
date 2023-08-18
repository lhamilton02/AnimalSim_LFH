import java.util.ArrayList;

public class Application {
    public static void main(String[] args)
    {
        runLocationTests();
        runAnimalTests();
        runGoldfinchTests();
        runBrownBearTests();
        runGenericsTests();
    }

    
    // Location Tests
    private static void runLocationTests() 
    {
        testLocationEmptyConstructor();
        testLocationPreferredConstructor();
        testLocationUpdateMethod();
    }
    
    private static void testLocationEmptyConstructor() 
    {
    	 System.out.println("*********************************************");
         System.out.println("      Location Tests ");
         System.out.println("*********************************************");

        System.out.println("Testing Location empty constructor...");

        try 
        {
            Location l = new Location();
            int[] coordinates = l.getCoordinates();

            if (coordinates[0] == 0 && coordinates[1] == 0) 
            {
                System.out.println("Passed.");
            } else 
            {
                System.out.println("Failed.");
            }
        } catch (Exception e) 
        {
            System.out.println("Failed: " + e.getMessage());
        }
    }

    private static void testLocationPreferredConstructor() 
    {
        System.out.println("Testing location preferred constructor and InvalidCoordinateException...");
        try 
        {
            Location l = new Location(10, 20);
            int[] coordinates = l.getCoordinates();
            System.out.println("Coordinates: [" + coordinates[0] + ", " + coordinates[1] + "]");
        } 
        catch (InvalidCoordinateException e) 
        {
            System.out.println("InvalidCoordinateException caught: " + e.getMessage());
        }
        
        try 
        {
            Location location = new Location(-5, 15); // This should trigger an exception
            int[] coordinates = location.getCoordinates();
            System.out.println("Coordinates: [" + coordinates[0] + ", " + coordinates[1] + "]");
        } catch (InvalidCoordinateException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void testLocationUpdateMethod() {
        System.out.println("Testing update method...");
        try {
            Location l = new Location();
            l.update(5, 10);
            int[] coordinates = l.getCoordinates();
            System.out.println("Updated Coordinates: [" + coordinates[0] + ", " + coordinates[1] + "]");
        } catch (InvalidCoordinateException e) {
            System.out.println("InvalidCoordinateException caught: " + e.getMessage());
        }
        
    }


    // Animal Tests
    private static void runAnimalTests() 
    {
        testAnimalEmptyConstructor();
        testAnimalPreferredConstructor();
        testAnimalEatMethod();
        testAnimalSleepMethod();
        testInvalidSimIDException();
    }

    private static void testAnimalEmptyConstructor()
    {
        System.out.println("*********************************************");
        System.out.println("      Animal Tests");
        System.out.println("*********************************************");

       /** 
        * Animal is abstract, you cant directly instantiate it
        * Animal animal = new Animal();
        * System.out.println(animal);
    }
		*/
    }
    
    private static void testAnimalPreferredConstructor() 
    {
        System.out.println("Testing Animal preferred constructor");
       
        try 
        {
            Location l = new Location(10, 20); // Replace with valid coordinates

            Animal animal1 = new Goldfinch(1, l, 9.0);
            Animal animal2 = new BrownBear(2, l, "Kodiak");

            System.out.println(animal1);
            System.out.println(animal2);

        } catch (InvalidSimIDException e)
        {
            System.out.println("InvalidSimIDException: " + e.getMessage());
        }
    }

    private static void testAnimalEatMethod() 
    {
        System.out.println("Testing eat method...");
        Location l = new Location(10, 20); 

        Animal a = new Goldfinch(1, l, 9.0); 

        System.out.println("Before eating: " + a);
        a.eat();
        System.out.println("After eating: " + a);
    }

    private static void testAnimalSleepMethod() 
    {
        System.out.println("Testing sleep method...");

        Location l = new Location(5, 10); 

        Animal a = new BrownBear(2, l, "Kodiak"); 

        System.out.println("Before sleeping: " + a);
        a.sleep();
        System.out.println("After sleeping: " + a);
    }


    private static void testInvalidSimIDException() {
        System.out.println("Testing InvalidSimIDException...");

        try
        {
            Animal animal = new BrownBear(-1, new Location(5, 10), "Kodiak"); 
        } catch (InvalidSimIDException e) 
        {
            System.out.println(e.getMessage());
        }
    }


    // Goldfinch Tests
    private static void runGoldfinchTests() {
        testGoldfinchEmptyConstructor();
        testGoldfinchPreferredConstructor();
        testGoldfinchWalkMethod();
        testGoldfinchFlyMethod();
    }

    private static void testGoldfinchEmptyConstructor()
    {
        System.out.println("*********************************************");
        System.out.println("      Goldfinch Tests");
        System.out.println("*********************************************");

        try 
        {
            Goldfinch goldfinch = new Goldfinch();
            System.out.println(goldfinch.toString());
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    private static void testGoldfinchPreferredConstructor() {
        System.out.println("Testing preferred constructor...");
        try 
        {
            Location location = new Location(10, 20); 
            Goldfinch goldfinch = new Goldfinch(1, location, 8.0); 
            System.out.println(goldfinch.toString());
        } 
        catch (INvalidwingspanException e)
        {
            System.out.println(e.getMessage());
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }

    private static void testGoldfinchWalkMethod() 
    {
        System.out.println("Testing walk method...");
        try {
        	
            Location location = new Location(10, 20);
            Goldfinch goldfinch = new Goldfinch(1, location, 8.0); 
            
            System.out.println("Before walking: " + goldfinch.toString());
            
            goldfinch.walk(5, "east"); 
            
            System.out.println("After walking: " + goldfinch.toString());
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }

    private static void testGoldfinchFlyMethod() {
        System.out.println("Testing fly method.");
        try 
        {
            Location l = new Location(30, 40); 
            Goldfinch goldfinch = new Goldfinch(2, l, 9.5); 
            
            Location newLocation = new Location(50, 60); 
            goldfinch.fly(newLocation);
            
            System.out.println("After flying: " + goldfinch.toString());
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }


    // BrownBear Tests
    private static void runBrownBearTests() 
    {
        testBrownBearConstructor();
        testBrownBearGettersSetters();
        testBrownBearWalk();
        testBrownBearSwim();
    }

    private static void testBrownBearConstructor()
    {
        System.out.println("*********************************************");
        System.out.println("      BrownBear Tests ");
        System.out.println("*********************************************");

        try 
        {
            Location location = new Location(10, 20); 
            BrownBear b1 = new BrownBear(1, location, "Kodiak"); 
            
            BrownBear b2 = new BrownBear(); 
            b2.setSimID(2);
            b2.setLocation(location);
            b2.setSubSpecies("Grizzly");
            
            System.out.println("Bear 1: " + b1.toString());
            System.out.println("Bear 2: " + b2.toString());
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }

    private static void testBrownBearGettersSetters() {
        System.out.println("Tesing getters/setters...");

        try 
        {
            Location l = new Location(10, 20); 
            BrownBear b = new BrownBear(1, l, "Kodiak"); 
            
            System.out.println(b.toString());

            b.setSimID(2);
            b.setLocation(new Location(15, 25)); 
            b.setSubSpecies("Grizzly"); 

            System.out.println("Updated BrownBear Information:");
            System.out.println("Sim ID: " + b.getSimID());
            System.out.println("Location: " + b.getLocation().toString());
            System.out.println("Subspecies: " + b.getSubSpecies());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 
    private static void testBrownBearWalk() {
        System.out.println("Testing walk method...");
        try 
        {
            Location l = new Location(10, 20); 
            BrownBear b = new BrownBear(1, l, "Grizzly"); 
            
            System.out.println("Bear's initial location: " + b.getLocation().toString());
            
            b.walk(5, "north"); 
            System.out.println("Bear after walking north: " + b.getLocation().toString());
            
            b.walk(3, "west"); 
            System.out.println("Bear after walking west: " + b.getLocation().toString());
        } 
        catch (Exception e)
        {
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }
    
    private static void testBrownBearSwim() 
    {
        System.out.println("Tesing swim method");

        try 
        {
            Location l = new Location(10, 20); // Replace with valid coordinates
            BrownBear b = new BrownBear(1, l, "Kodiak"); // Replace with valid subSpecies

            System.out.println(b.getLocation().toString());

            b.swim(5, "north");

            System.out.println("Updated location:");
            System.out.println(b.getLocation().toString());
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }

    // Generics Tests
    private static void runGenericsTests() 
    {
        System.out.println("*********************************************");
        System.out.println("      Generics Tests");
        System.out.println("*********************************************");

        // Instantiate an ArrayList object that can hold any type of Animal
        ArrayList<Animal> animalList = new ArrayList<>();

        // Fill the ArrayList object with at least two animals 
        animalList.add(new BrownBear(1, new Location(10, 20), "Alaskan"));
        animalList.add(new BrownBear(2, new Location(15, 25), "Grizzly"));
        animalList.add(new Goldfinch(3, new Location(5, 10), 8.5));
        animalList.add(new Goldfinch(4, new Location(3, 6), 6.2));

        // Iterate through the ArrayList object and call the toString() method 
        for (Animal animal : animalList) {
            System.out.println(animal.toString());
        }
    }
}
