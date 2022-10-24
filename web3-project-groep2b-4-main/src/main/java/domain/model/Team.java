package domain.model;

public enum Team {
    alpha("alpha"), beta("beta"), gamma("gamma"), delta("delta"), epsilon("epsilon");

    private String stringValue;

    Team(String stringValue) {
        this.stringValue = stringValue;
    }

    private void Group(String stringValue){
        this.stringValue=stringValue;
    }

    public String getStringValue() {return stringValue;}



}