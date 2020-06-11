package model;

public class MatchedProperty {
    Property property;
    Double matchPercent;

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Double getMatchPercent() {
        return matchPercent;
    }

    public void setMatchPercent(Double matchPercent) {
        this.matchPercent = matchPercent;
    }
}
