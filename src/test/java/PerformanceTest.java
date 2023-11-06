import org.junit.jupiter.api.Test;

public class PerformanceTest {

    @Test
    public void testExpression2() {
        long startTime = System.nanoTime();
        int result = 0;
        for (int i = 0; i < 1000000; i++) {
            result = 2 * i * i;
        }
        long endTime = System.nanoTime();
        System.out.println("Expression 2 took " + (endTime - startTime) + " nanoseconds.");
    }

    @Test
    public void testExpression1() {
        long startTime = System.nanoTime();
        int result = 0;
        for (int i = 0; i < 1000000; i++) {
            result = 2 * (i * i);
        }
        long endTime = System.nanoTime();
        System.out.println("Expression 1 took " + (endTime - startTime) + " nanoseconds.");
    }


}
