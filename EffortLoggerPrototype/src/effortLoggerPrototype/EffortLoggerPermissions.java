package effortLoggerPrototype;

import javafx.scene.paint.Color;

public class EffortLoggerPermissions {
	
	private static int[] validIds = { 12345678, 87654321, 11111111, 99999999, 12216758, 12215678, 12214567 };

    public static boolean isIdValid(String id) {
    	int inputId = 0;
    	
    	if (id.length() == 8) 
    	{
            try 
            {
                inputId = Integer.parseInt(id);
            } 
            catch (NumberFormatException e) 
            {
            	return false;
            }
        } 
    	else 
    	{

            	return false; 
        }

    	for (int validId : validIds) 
    	{
            if (inputId == validId) 
            {
                return true;
            }
        }

        return false;
    }
    
    
    
    public static boolean isSupervisor(String id) {
    	int inputId = Integer.parseInt(id)/10000;
    	int superKey = 1221;
    	
    	if (inputId == superKey) 
    	{
            return true;
        } 
    	else 
        {
            return false; 
        }

    }
	
	
}
