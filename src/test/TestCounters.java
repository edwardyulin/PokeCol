//import ui.Counters;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class TestCounters {
//
//
//    private Counters waterCounter;
//    private Counters grassCounter;
//    private Counters fireCounter;
//    private Counters normalCounter;
//
//    @BeforeEach
//    void setUp() {
//        waterCounter = new Counters("Squirtle", null);
//        fireCounter = new Counters("Charmander", null);
//        grassCounter = new Counters("Bulbasaur", null);
//        normalCounter = new Counters("Pidgey", null);
//
//    }
//
//    @Test
//    void testWaterType() {
//        assertEquals("Water", waterCounter.typeIdentifier("Squirtle", null));
//    }
//
//    @Test
//    void testFireType() {
//        assertEquals("Fire", fireCounter.typeIdentifier("Charmander", null));
//    }
//
//    @Test
//    void testGrassType() {
//        assertEquals("Grass", grassCounter.typeIdentifier("Bulbasaur", null));
//    }
//
//    @Test
//    void testOtherType() {
//        assertEquals("", normalCounter.typeIdentifier("Pidgey", null));
//    }
//
//}
