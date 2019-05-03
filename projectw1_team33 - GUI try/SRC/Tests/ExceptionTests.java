package Tests;

import Exceptions.Overexertion;
import Exceptions.WorkHarder;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import ui.Main;
import org.junit.jupiter.api.Test;
import ui.WorkoutScheduler;

import static junit.framework.TestCase.fail;

public class ExceptionTests {
    Main main;

    @BeforeEach
    public void Setup() {
        main = new Main();
    }

    @Test
    public void TestTooManyReps() {
        try {
            WorkoutScheduler.WorkingTooHard(13);
            fail("Should have been exception");
        } catch (Overexertion e) {
            System.out.print("YAY!");
        }
    }


    @Test
    public void TestJustEnoughUpperReps() {
        try {
            WorkoutScheduler.WorkingTooHard(12);
            System.out.print("YAY!");
        } catch (Overexertion e) {
            fail("12 is good amount");
        }
    }

    @Test
    public void TestNotEnoughReps() {
        try {
            WorkoutScheduler.WorkHarder(7);
            fail("Should have been exception");
        } catch (WorkHarder workHarder) {
            System.out.print("YAY!");
        }
    }

    @Test
    public void TestJustEnoughLowerReps() {
        try {
            WorkoutScheduler.WorkHarder(8);
            System.out.print("YAY!");
        } catch (WorkHarder workHarder) {
            fail("8 is good amount");
        }
    }

    @Test
    public void TestStringforReps() {
        String Reps = "tt";
        try{
            Integer Repsresult = Integer.valueOf(Reps);
            fail("String is not an integer");
        }catch(NumberFormatException NFE){
            System.out.println("YAY!");

        }
    }
    @Test
    public void TestIntforReps() {
        Integer Reps = 5;
        try{
            Integer Repsresult = Integer.valueOf(Reps);
            System.out.println("YAY!");
        }catch(NumberFormatException NFE){
            fail("Integer is int");

        }
    }
}
