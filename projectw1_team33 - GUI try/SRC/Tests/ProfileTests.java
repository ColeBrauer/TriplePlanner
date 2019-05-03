package Tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Models.Profile;
import Models.ResponsibilityProfile;
import ui.EventScheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileTests {
    Profile test;

    @BeforeEach
    public void setup(){
        test = new ResponsibilityProfile();
    }

    @Test
    public void TestSetName(){

        assertFalse(test.getName() == "Cole");
        test.setName("Cole");
        assertTrue(test.getName() == "Cole");
    }

    @Test
    public void TestLoad(){
         test.load("Test.txt");
        assertTrue(test.getResponsibilities().size() == 1);

    }

    @Test
    public void TestSave(){
        test.save("SAVETEST.txt");
        test.load("SAVETEST.txt");
        assertEquals(test.getResponsibilities().size(), 0);
        test.setResponsibilities("HELLO WORLD!!!");
        test.save("SAVETEST.txt");
        test.load("SAVETEST.txt");
        assertEquals(test.getResponsibilities().size(), 2);
        test.setResponsibilities("this is a second item");
        assertEquals(test.getResponsibilities().size(), 3);
        test.load("SAVETEST.txt");
        assertEquals(test.getResponsibilities().size(), 4);
        test.save("SAVETEST.txt");
        Profile newprofile = new ResponsibilityProfile();
        newprofile.load("SAVETEST.txt");
        assertEquals(newprofile.getResponsibilities().size(), 4);

    }

    @Test
    public void TestSetprocrastinationpoints(){

        assertEquals(0,test.getProcrastinationPoints());
        test.setProcrastinationPoints(2);
        assertEquals(2, test.getProcrastinationPoints());
        test.setProcrastinationPoints(3);
        assertEquals(5, test.getProcrastinationPoints());
        test.setProcrastinationPoints(-10);
        assertEquals(-5, test.getProcrastinationPoints());
    }

    @Test
    public void TestSetResponsibilities() {

        assertEquals(0, test.getResponsibilities().size());
        test.setResponsibilities("Homework");
        assertEquals(1, test.getResponsibilities().size());

    }

}
