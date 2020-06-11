package utilities;

import static java.lang.StrictMath.*;

public class RequestValidator {
    public static boolean isRequestValid(int id, double latitude, double longitude, long  min_budget, long  max_budget, int min_bedrooms,
                                         int max_bedrooms, int min_bathrooms, int max_bathrooms) {
        if(max(min_budget, max_budget) > 0 && max(min_bedrooms, max_bedrooms) > 0 && max(min_bathrooms, max_bathrooms) > 0)
            return true;  // valid request
        //More validation checks can be added here
        return false;	// invalid request
    }
}
