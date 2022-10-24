package domain.model;

public enum Role {
    director("director"), teamleader("teamleader"), employee("employee");

    private String stringValue;

    Role(String stringValue){
        this.stringValue=stringValue;
    }

    public String getStringValue() {return stringValue;}
}
