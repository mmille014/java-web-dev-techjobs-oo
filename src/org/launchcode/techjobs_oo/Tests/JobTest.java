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
        job4 = new Job("Product tester",
                new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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

        assertTrue(job3 instanceof Job);
        assertEquals(1, job3.getId());
        assertEquals("Product tester", job3.getName());
        assertEquals("Acme", job3.getEmployer().getValue());
        assertEquals("Desert",
                job3.getLocation().getValue());
        assertEquals("Quality control",
                job3.getPositionType().getValue());
        assertEquals("Persistence",
                job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job3.equals(job4));
    }
}
