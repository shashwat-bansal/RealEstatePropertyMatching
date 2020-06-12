package utilities;

import static java.lang.StrictMath.*;

public class MatchingUtility {

    /**Returns 30% match if distance is less than 2 miles
     * Else follows equation (30.0 - ((10-distance)*3.75) to calculate match
     * No match is considered if value is <= 0
     */
    public static double getDistanceMatch(double latitude, double longitude, double requestLatitude, double requestLongitude) {
        double u = sin((requestLatitude - latitude) / 2);
        double v = sin((requestLongitude - longitude) / 2);
        double w = cos(latitude) * cos(requestLatitude);
        double distance = 2.0 * 3959 * sin(sqrt(u * u + w * v * v));
        if(distance <= 2.0)
            return 30.0;
        return 30.0-((10-distance)*3.75);
    }

    /**Returns 30% match if price is under given constraints
     * Follows equation 30.0 - 100*(budget-price)/price if one of the constraint is missing
     * No match is considered if value is <= 0
     */
    public static double getPriceMatch(Long price, Long min_budget, Long max_budget) {
        if (min_budget <= price && price <= max_budget)
            return 30.0;
        double difference_min = 100.0;
        double difference_max = 100.0;
        if (min_budget != -1)
            difference_min = 100.0 * (abs(min_budget - price) / price);
        if (max_budget != -1)
            difference_max = 100.0 * (abs(max_budget - price) / price);
        double difference = min(difference_min, difference_max);
        return 30.0 - difference;
    }

    /**Returns 20% match if number of bedrooms is under given constraints
     * Returns 10% match if number of bedrooms differ by 1 when any one of the constraint is missing
     * No match is considered if value is <= 0
     */
    public static double getBedroomMatch(int bedrooms, int min_bedrooms, int max_bedrooms) {
        if(min_bedrooms <= bedrooms && bedrooms <= max_bedrooms)
            return 20.0;
        int difference_min = 3, difference_max = 3, difference;
        if(min_bedrooms != -1) difference_min = abs(min_bedrooms-bedrooms);
        if(max_bedrooms != -1) difference_max = abs(max_bedrooms-bedrooms);
        difference = min(difference_min, difference_max);
        return 20.0-((2.0-difference)*10);
    }

    /**Returns 20% match if number of bathrooms is under given constraints
     * Returns 10% match if number of bathrooms differ by 1 when any one of the constraint is missing
     * No match is considered if value is <= 0
     */
    public static double getBathroomMatch(int bathrooms, int min_bathrooms, int max_bathrooms) {
        if(min_bathrooms <= bathrooms && bathrooms <= max_bathrooms) return 20.0;
        int difference_min = 3, difference_max = 3, difference;
        if(min_bathrooms != -1) difference_min = abs(min_bathrooms-bathrooms);
        if(max_bathrooms != -1) difference_max = abs(max_bathrooms-bathrooms);
        difference = min(difference_min, difference_max);
        return 20.0-((2.0-difference)*10);
    }
}
