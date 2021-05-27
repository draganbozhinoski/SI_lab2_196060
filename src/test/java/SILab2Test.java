import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private SILab2 objekt;
    @Test
    void everyStatementTest()
    {

        //times.add(new Time(-1,0,0));
        //times.add(new Time(25,0,0));
        //times.add(new Time(20,-3,0));
        //times.add(new Time(20,2,65));
        //times.add(new Time(20,2,15));
        //times.add(new Time(24,0,0));
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> objekt.function(List.of(new Time(-1,0,0))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));
        ex = assertThrows(RuntimeException.class, () -> objekt.function(List.of(new Time(25,0,0))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));
        ex = assertThrows(RuntimeException.class, () -> objekt.function(List.of(new Time(20,-3,0))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));
        ex = assertThrows(RuntimeException.class, () -> objekt.function(List.of(new Time(20,2,65))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));
        assertEquals(72135, objekt.function(List.of(new Time(20,2,15))).get(0));
        assertEquals(86400,objekt.function(List.of(new Time(24,0,0))).get(0));
    }
    @Test
    void multipleConditionsTest()
    {
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> objekt.function(List.of(new Time(-1,0,5))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> objekt.function(List.of(new Time(26,0,5))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> objekt.function(List.of(new Time(20,-3,5))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> objekt.function(List.of(new Time(20,76,5))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> objekt.function(List.of(new Time(20,20,-234))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> objekt.function(List.of(new Time(20,20,552))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        assertEquals(72135, objekt.function(List.of(new Time(20,2,15))).get(0));
    }

}