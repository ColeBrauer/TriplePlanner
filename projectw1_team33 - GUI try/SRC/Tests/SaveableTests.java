package Tests;

import Interfaces.Loadable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Models.Profile;
import Models.ResponsibilityProfile;

public class SaveableTests {

    Loadable testP;
    Profile testa = new ResponsibilityProfile();

    @BeforeEach
    void setup(){
        testP = new ResponsibilityProfile();

    }
    @Test
    public void Testsave(){

    }
}
