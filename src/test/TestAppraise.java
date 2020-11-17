//import ui.Appraise;
//import model.Pokemon;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class TestAppraise {
//    private static final String big = "big";
//    private static final String mid = "mid";
//    private static final String small = "small";
//    private Pokemon bigPikachu;
//    private Pokemon midPikachu;
//    private Pokemon smallPikachu;
//    private ArrayList<Integer> bigStat;
//    private ArrayList<Integer> midStat;
//    private ArrayList<Integer> smallStat;
//
//    private Appraise pikachu;
//    private static int WIDTH = 800;
//    private static int HEIGHT = 600;
//    private JFrame frame;
//
//    @BeforeEach
//    public void setup() {
//        bigStat = new ArrayList<>();
//        bigStat.add(15);
//        bigStat.add(15);
//        bigStat.add(15);
//        midStat = new ArrayList<>();
//        midStat.add(7);
//        midStat.add(7);
//        midStat.add(9);
//        smallStat = new ArrayList<>();
//        smallStat.add(1);
//        smallStat.add(1);
//        smallStat.add(1);
//        bigPikachu = new Pokemon("Pikachu",bigStat);
//        midPikachu = new Pokemon("Pikachu", midStat);
//        smallPikachu = new Pokemon("Pikachu", smallStat);
//        frame = new JFrame();
//        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
//        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
//        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
//
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//
//        JPanel panel = new JPanel();
//        frame.add(panel);
//        pikachu = new Appraise("Pikachu", "1", panel);
//    }
//
//    @Test
//    void testBigAppSystem() {
//        assertEquals(big, pikachu.appraiseSystem(bigPikachu, "1", null));
//    }
//
//    @Test
//    void testMidAppSystem() {
//        assertEquals(mid, pikachu.appraiseSystem(midPikachu, "2", null));
//    }
//
//    @Test
//    void testSmallAppSystem() {
//        assertEquals(small, pikachu.appraiseSystem(smallPikachu, "3", null));
//    }
//
//    @Test
//    void testNoBerry() {
//        assertEquals(small, pikachu.appraiseSystem(smallPikachu, "none", null));
//    }
//
//}
