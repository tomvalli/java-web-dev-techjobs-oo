package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job job1, job2;

    @Before
    public void createJobs() {
        job1 = new Job();
        job2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertEquals(job1.getId(), (job2.getId()-1), 0);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job3.getName() instanceof String);
        assertEquals(job3.getName(), "Product tester");

        assertTrue(job3.getEmployer() instanceof Employer);
        assertEquals(job3.getEmployer().getValue(), "ACME");

        assertTrue(job3.getLocation() instanceof Location);
        assertEquals(job3.getLocation().getValue(), "Desert");

        assertTrue(job3.getPositionType() instanceof PositionType);
        assertEquals(job3.getPositionType().getValue(), "Quality control");

        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringBlankLines() {
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job6.toString();

        assertEquals(jobString.indexOf("\n"), 0, 0);
        assertEquals(jobString.lastIndexOf("\n"), (jobString.length() - 1), 0);
    }

    @Test
    public void testToStringLabels() {
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job6.toString();
        //arr of job labels:
        String[] labels = {"ID: ", "Name: ", "Employer: ", "Location: ", "Position Type: ", "Core Competency: "};
        //arr of the values corresponding to those labels
        String[] values = {Integer.toString(job6.getId()), job6.getName(), job6.getEmployer().getValue(), job6.getLocation().getValue(), job6.getPositionType().getValue(), job6.getCoreCompetency().getValue()};

        for (int i = 0; i < values.length; i++) {
            int labelIndex = jobString.indexOf(labels[i]);
            int labelLength = labels[i].length();
            int valueIndexActual = jobString.indexOf(values[i]);
            int valueIndexCalculated = labelIndex + labelLength;
            assertEquals('\n', jobString.charAt(labelIndex - 1));
            assertEquals(valueIndexActual, valueIndexCalculated, 0);
        }
    }

    @Test
    public void testForMessageInEmptyField() {
        Job job7 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job7.toString();
        String emptyFieldName = "Name: ";
        assertEquals(jobString.indexOf("Data not available"), jobString.indexOf("Name: ") + emptyFieldName.length());
    }

    @Test
    public void testEmptyJobToStringError() {
        Job job8 = new Job();
        assertEquals("OOPS! This job does not seem to exist.", job8.toString());
    }
}
