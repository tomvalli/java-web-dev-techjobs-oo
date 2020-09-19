package org.launchcode.techjobs_oo;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    // TODO: -Review Sally’s code in the Employer class to learn how to assign a unique ID.
    //  -Add getters, setters, and custom methods as needed to the Location, CoreCompetency, and PositionType classes.
    //  -Complete the Job class using what you learned in steps 1 and 2.
    //  -Use unit testing to verify the constructors and equals methods for the Job class.
    //  -Use TDD to design and code a custom toString method for the Job class.
    //  -Use inheritance to DRY the code within Employer, Location, CoreCompetency, and PositionType
}
