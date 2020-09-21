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
    private final String noData = "Data not available";

    public Job() {
        this.id = nextId;
        nextId++;
        this.name = noData;
        this.employer = new Employer(noData);
        this.location = new Location(noData);
        this.positionType = new PositionType(noData);
        this.coreCompetency = new CoreCompetency(noData);
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
        String[] labels = {"ID: ", "Name: ", "Employer: ", "Location: ", "Position Type: ", "Core Competency: "};
        String[] values = {Integer.toString(this.id), this.name, this.employer.getValue(),
                            this.location.getValue(), this.positionType.getValue(), this.coreCompetency.getValue()};
        StringBuilder output = new StringBuilder("\n" + labels[0] + values[0]);

        boolean idOnly = true;
        for (int i = 1; i < values.length; i++) {
            output.append("\n").append(labels[i]);
            if (!values[i].equals(noData)) {
                output.append(values[i]);
                idOnly = false;
            }
            if (values[i].isEmpty()) {
                output.append(noData);
            }
            if (i == values.length-1) {
                output.append("\n");
            }
        }

        if(idOnly) { output = new StringBuilder("OOPS! This job does not seem to exist."); }

        return output.toString();
    }
    //  -Use inheritance to DRY the code within Employer, Location, CoreCompetency, and PositionType
}
