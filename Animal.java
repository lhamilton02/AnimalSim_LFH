import java.util.Random;

abstract class Animal 
{
	//instance variables
    protected int simID;
    protected Location location;
    protected boolean full;
    protected boolean rested;

    // Empty-argument constructor
    public Animal() 
    {
        this.simID = 0;
        this.location = new Location();
        this.full = false;
        this.rested = true;
    }

    // Preferred constructor
    public Animal(int simID, Location location)
    {
        if (simID <= 0)
        {
            throw new InvalidSimIDException("simID should be greater than zero.");
        }
        this.simID = simID;
        this.location = location;
        this.full = false;
        this.rested = true;
    }

    /**Generate eat method -  random number between 0/1,
       if number is .5 or lower full=false otherwise true
     */
    public void eat() 
    {
        Random r = new Random();
        if (r.nextDouble() <= 0.5) 
        {
            full = false;
        } else
        {
            full = true;
        }
    }

    /** Sleep Method
       Generate random number beteween 0/1
       if number is .5 or lower rested = full
     */  
    public void sleep()
    {
        Random rand = new Random();
        if (rand.nextDouble() <= 0.5) 
        {
            rested = false;
        } else {
            rested = true;
        }
    }

    // Getters and setters

    public int getSimID() 
    {
        return simID;
    }
  
    public void setSimID(int simID) 
    {
		this.simID = simID;
	}

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location) 
    {
        this.location = location;
    }

    public boolean isFull() 
    {
        return full;
    }
   
    public void setFull(boolean full)
    {
		this.full = full;
	}

    public boolean isRested() 
    {
        return rested;
    }
	
	public void setRested(boolean rested) 
	{
		this.rested = rested;
	}

	//toString method
    @Override
    public String toString()
    {
        return "Animal: [simID=" + simID +
                ", location=" + location +
                ", full=" + full +
                ", rested=" + rested +
                "]";
    }//end toString method
    
}//end Animal class
