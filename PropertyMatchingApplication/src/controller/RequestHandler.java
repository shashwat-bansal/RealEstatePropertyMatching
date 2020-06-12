package controller;

import model.*;
import utilities.CustomComparator;

import java.util.ArrayList;
import static java.lang.StrictMath.*;

import static utilities.MatchingUtility.*;

public class RequestHandler {
    private ArrayList<Property> allProperties;

    //This function will be called to get Matching properties in decreasing order of match percentage
    public ArrayList<MatchedProperty> getMatchedProperties(int requestId, double requestLatitude, double requestLongitude, long minBudget,
                                                           long maxBudget, int minBedrooms, int maxBedrooms, int minBathrooms, int maxBathrooms){

        ArrayList<MatchedProperty> matchedProperties =new ArrayList<>();
        //Validating the request. Empty list is returned in case request is not valid
        if(!isRequestValid(requestId,requestLatitude,requestLongitude,minBudget,maxBudget,minBedrooms,maxBedrooms,minBathrooms,maxBathrooms))
            return matchedProperties;

        //Fetching all properties from DB if request is valid
        getAllProperties();

        for(int index =0; index < allProperties.size(); index++){
            //Using utility functions to get match percentage
            double distanceMatch = getDistanceMatch(allProperties.get(index).getLatitude(),allProperties.get(index).getlongitude(),
                    requestLatitude,requestLongitude);
            double priceMatch = getPriceMatch(allProperties.get(index).getPrice(),minBudget,maxBudget);
            double bedroomMatch = getBedroomMatch(allProperties.get(index).getBedrooms(),minBedrooms,maxBedrooms);
            double bathroomMatch = getBathroomMatch(allProperties.get(index).getBathrooms(),minBathrooms,maxBathrooms);

            double match = distanceMatch + priceMatch + bathroomMatch + bathroomMatch;

            if(distanceMatch <= 0 || priceMatch <= 0 || bedroomMatch <= 0 || bathroomMatch <= 0 || match < 40)
                continue; //Not adding the property if there is no match
            MatchedProperty matchedProperty=new MatchedProperty();
            matchedProperty.setProperty(allProperties.get(index));
            matchedProperty.setMatchPercent(match); //Setting match % of matched property
            matchedProperties.add(matchedProperty);
        }
        //Sorting in decreasing order of match percent
        matchedProperties.sort(new CustomComparator());
        return matchedProperties;
    }

    private boolean isRequestValid(int id, double latitude, double longitude, long  min_budget, long  max_budget, int min_bedrooms,
                                         int max_bedrooms, int min_bathrooms, int max_bathrooms) {
        if(max(min_budget, max_budget) > 0 && max(min_bedrooms, max_bedrooms) > 0 && max(min_bathrooms, max_bathrooms) > 0)
            return true;  // valid request
        //More validation checks can be added here
        return false;	// invalid request
    }

    private void getAllProperties(){
        allProperties = new ArrayList<>();
        //
        //
        //
        //This method will interact with accessor to fetch all properties from database
        //
        //
        //
        //
    }
}
