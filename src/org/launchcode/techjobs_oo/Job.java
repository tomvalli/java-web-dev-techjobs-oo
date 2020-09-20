package org.launchcode.techjobs_oo;

import java.util.ArrayList;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String output = "";
        String[] labels = {"ID: ", "Name: ", "Employer: ", "Location: ", "Position Type: ", "Core Competency: "};
        String[] values = {Integer.toString(this.id), this.name, this.employer.getValue(), this.location.getValue(), this.positionType.getValue(), this.coreCompetency.getValue()};

        for (int i = 0; i < values.length; i++) {
            output += "\n" + labels[i];
            if (values[i].equals("")) {
                output += "Data not available";
            } else {
                output += values[i];
            }
        }

        return output;


//        return "\n" +
//                "ID: " + id +
//                "\nName: " + name +
//                "\nEmployer: " + employer +
//                "\nLocation: " + location +
//                "\nPosition Type: " + positionType +
//                "\nCore Competency: " + coreCompetency +
//                '\n';
    }

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
