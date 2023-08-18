
public class Goldfinch extends Animal implements Walkable, Flyable {
   
	//instance variable
	private double wingSpan;

    // Empty-argument constructor
    public Goldfinch() 
    {
        super();
        this.wingSpan = 9.0;
    }

    // Preferred constructor
    public Goldfinch(int simID, Location location, double wingSpan) 
    {
        super(simID, location);
        validateWingSpan(wingSpan);
        this.wingSpan = wingSpan;
        
    }
    
    // Walkable interface
    public void walk(int distance, String direction)
    {
        Location currentLocation = getLocation(); 


        int[] coordinates = currentLocation.getCoordinates();

        switch (direction.toLowerCase())
        {
            case "north":
                coordinates[1] += distance; 
                break;
            case "south":
                coordinates[1] -= distance;  
                break;
            case "east":
                coordinates[0] += distance; 
                break;
            case "west":
                coordinates[0] -= distance; 
                break;
        }

        //Updating and setting new location
        currentLocation.update(coordinates[0], coordinates[1]);
        setLocation(currentLocation);
    }
    // Implementing the Flyable interface

    public void fly(Location location) 
    {
        setLocation(location); // Set the new location
    }
    
    // Method catch and handle InvalidWingspanException
    //Must be floating point number between 5 and 11cm.
    private void validateWingSpan(double wingSpan) 
    {
        if (wingSpan < 5.0 || wingSpan > 11.0)
        {
            throw new INvalidwingspanException("Invalid wingspan. Must be between 5 and 11 cm.");
        }
    }

    // Getters and setters
    public double getWingSpan() 
    {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan)
    {
        validateWingSpan(wingSpan);
        this.wingSpan = wingSpan;
    }

    //toString Method
    @Override
    public String toString() 
    {
        return "Goldfinch: [simID=" + getSimID() +
                ", location=" + getLocation() +
                ", wingSpan=" + wingSpan +
                ", full=" + isFull() +
                ", rested=" + isRested() +
                "]";
    }//end toString method
    
}//end Goldfinch class
