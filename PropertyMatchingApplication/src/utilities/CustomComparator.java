package utilities;

import model.MatchedProperty;

import java.util.Comparator;

public class CustomComparator implements Comparator<MatchedProperty> {
    @Override
    public int compare(MatchedProperty mp1, MatchedProperty mp2) {
        //Custom comparator to sort the matched properties in decreasing order
        return -(mp1.getMatchPercent().compareTo(mp2.getMatchPercent()));
    }
}
