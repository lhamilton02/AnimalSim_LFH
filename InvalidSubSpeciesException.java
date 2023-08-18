// Custom exception for InvalidSubspeciesException
class InvalidSubspeciesException extends RuntimeException 
{
    public InvalidSubspeciesException(String message) 
    {
        super(message);
    }
}