
// Location class encapsulates a point on a simulation map
public class Location
{
    // Instance variables for coordinates
    private int xCoord;
    private int yCoord;

    
    //method to validateCoordinates
    private void validateCoordinate(int x, int y)
    {
        if (x < 0 || y < 0)  
        {
            throw new InvalidCoordinateException("Invalid. Coordinates cannot be less than zero.");
        }
    }
    
    
    // Empty-argument constructor
    public Location()
    {
        this.xCoord = 0;
        this.yCoord = 0;
    }

    // Preferred constructor 
    public Location(int x, int y) 
    {
        validateCoordinate(x,y);//ensure data is valid
        this.xCoord = x;
        this.yCoord = y;
    }

    // update method
    public void update(int x, int y) 
    {
        validateCoordinate(x,y);
        this.xCoord = x;
        this.yCoord = y;
    }//end update method

    // getCoordinates method - returns array coordinates
    public int[] getCoordinates()
    {
        int[] coordinates = {xCoord, yCoord};
        return coordinates;
    }
    
    
}
 
/** 
 * public class Location //without using a validate method 
{
    //instance variable
    private int xCoord;
    private int yCoord;

    // Empty-argument constructor 
    public Location() 
    {
        this.xCoord = 0;
        this.yCoord = 0;
    }

    // Preferred constructor - initializes coordinates with data passed into it
    public Location(int x, int y) throws InvalidCoordinateException 
    {
        // catching invalidCoordinate and throwing exception
        if (x < 0 || y < 0) 
        {
            throw new InvalidCoordinateException("Invalid. Coordinates cannot be less than zero.");
        }
        this.xCoord = x;
        this.yCoord = y;
    }

    // update Method 
    public void update(int x, int y) throws InvalidCoordinateException 
    {
        // handling exception, ensure coordinates are valid
        if (x < 0 || y < 0) 
        {
            throw new InvalidCoordinateException("Coordinates cannot be less than zero.");
        }
        this.xCoord = x;
        this.yCoord = y;
    }//end update method
	
	//getCoordinates method
    public int[] getCoordinates() 
    {
        int[] coordinates = {xCoord, yCoord};
        return coordinates;
    }//end getCoordinates method
    
}//end class
 */






