package org.launchcode.techjobs_oo.Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    private Job job1, job2, job3, job4;

    @Before
    public void setupJobObjects() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @After
    public void clearJobObjects() {
        Job.resetMaxId();
    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, job2.getId() - job1.getId());
    }

    @Test
    public void testFullJobConstructor() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester",job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job3.equals(job4));
    }

    @Test
    public void testStringsHaveBlankLineBeforeAndAfterJobInformation() {
        char firstChar = job3.toString().charAt(0);
        char lastChar = job3.toString().charAt(job3.toString().length()-1);

        assertTrue(firstChar == lastChar);
    }

    @Test
    public void testJobsToString() {
        String output = "\nId: " + job3.getId() +
                "name: " + job3.getName() + "\n" +
                "employer: " + job3.getEmployer().getValue() + "\n" +
                "location: " + job3.getLocation().getValue() + "\n" +
                "positionType: " + job3.getPositionType().getValue() + "\n" +
                "coreCompetency: " + job3.getCoreCompetency().getValue() + "\n";
        assertEquals(output, job3.toString());
    }

    @Test
    public void testEmptyFieldOnJobsToString() {
        job3.getEmployer().setValue("");
        job3.getPositionType().setValue("");
        String output = "\nId: " + job3.getId() +
                "name: " + job3.getName() + "\n" +
                "employer: Data not available\n" +
                "location: " + job3.getLocation().getValue() + "\n" +
                "positionType: Data not available\n" +
                "coreCompetency: " + job3.getCoreCompetency().getValue() + "\n";
        assertEquals(output, job3.toString());
    }
}
