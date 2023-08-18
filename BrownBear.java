// BrownBear class


public class BrownBear extends Animal implements Walkable, Swimmable 
{
	
	//instance variable
    private String subSpecies;

    // Empty-argument constructor
    public BrownBear() 
    {
        super();
        this.subSpecies = "Alaskan";
    }

    // Preferred constructor
    public BrownBear(int simID, Location location, String subSpecies)
    {
        super(simID, location);
        validateSubSpecies(subSpecies);
        this.subSpecies = subSpecies;
    }
    
 // Implementing the Walkable interface
    @Override
    public void walk(int distance, String direction) 
    {
        Location currentLocation = getLocation();
        int[] coordinates = currentLocation.getCoordinates();

        switch (direction.toLowerCase()) 
        {
            case "north":
                coordinates[1] += 3 * distance; // Move 3 units in the specified direction
                break;
            case "south":
                coordinates[1] -= 3 * distance;
                break;
            case "east":
                coordinates[0] += 3 * distance;
                break;
            case "west":
                coordinates[0] -= 3 * distance;
                break;
        }

        currentLocation.update(coordinates[0], coordinates[1]);
        setLocation(currentLocation);
    }//end walkable interface implementation

    // Implementing the Swimmable interface
    @Override
    public void swim(int distance, String direction)
    {
        Location currentLocation = getLocation();
        int[] coordinates = currentLocation.getCoordinates();

        switch (direction.toLowerCase()) 
        {
            case "north":
                coordinates[1] += 2 * distance; // Move 2 units in the specified direction
                break;
            case "south":
                coordinates[1] -= 2 * distance;
                break;
            case "east":
                coordinates[0] += 2 * distance;
                break;
            case "west":
                coordinates[0] -= 2 * distance;
                break;
        }

        currentLocation.update(coordinates[0], coordinates[1]);
        setLocation(currentLocation);
    } //end swimmable interface implementation
    
    
    // InvalidSubspeciesException
    private void validateSubSpecies(String subSpecies) 
    {
        String[] validSpecies = {"Alaskan", "Asiatic", "European", "Grizzly", "Kodiak", "Siberian"};
        boolean isValid = false;
        for (String species : validSpecies) 
        {
            if (species.equals(subSpecies))
            {
                isValid = true;
                break;
            }
        }
        if (!isValid) 
        {
            throw new InvalidSubspeciesException("Invalid.");
        }
    }

    // Getter and setter for subSpecies
    public String getSubSpecies()
    {
        return subSpecies;
    }

    public void setSubSpecies(String subSpecies) 
    {
        validateSubSpecies(subSpecies);
        this.subSpecies = subSpecies;
    }
    
    //toString method
    @Override
    public String toString() 
    {
        return "BrownBear: [simID=" + getSimID() +
                ", location=" + getLocation() +
                ", subSpecies=" + subSpecies +
                ", full=" + isFull() +
                ", rested=" + isRested() +
                "]";
    }//end toString method
    
}//end BrownBear class
