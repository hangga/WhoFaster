import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.StringJoiner;

@State(Scope.Benchmark)
public class Benchmark {

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(Benchmark.class.getSimpleName()) // Nama kelas benchmark
                .forks(1) // Jumlah fork (proses pengukuran)
                .build();

        new Runner(options).run();
    }
    @org.openjdk.jmh.annotations.Benchmark
    @BenchmarkMode(Mode.Throughput) // Mode pengukuran
    public void testExpression2() {
        long startTime = System.currentTimeMillis();
        int result = 0;
        for (int i = 0; i < 1000000; i++) {
            result = 2 * i * i;
        }
        long endTime = System.currentTimeMillis();
        //System.out.println("Expression 2 took " + (endTime - startTime) + " nanoseconds.");
        System.out.println("Expression 2 took " + convertMillisToTime(endTime - startTime));
    }

    //@Test
    @org.openjdk.jmh.annotations.Benchmark
    @BenchmarkMode(Mode.Throughput) // Mode pengukuran
    public void testExpression1() {
        long startTime = System.currentTimeMillis();
        int result = 0;
        for (int i = 0; i < 1000000; i++) {
            result = 2 * (i * i);
        }
        long endTime = System.currentTimeMillis();

        //System.out.println("Expression 1 took " + (endTime - startTime) + " nanoseconds.");
        System.out.println("Expression 1 took " + convertMillisToTime(endTime - startTime));
    }

    private String convertMillisToTime(long currentTimeMillis) {

        long totalMilliseconds = currentTimeMillis % 1000;
        long totalSeconds = (currentTimeMillis / 1000) % 60;
        long totalMinutes = (currentTimeMillis / 60000) % 60;
        long hours = (currentTimeMillis / 3600000);
        StringJoiner stringBuffer = new StringJoiner("");

        if (hours > 0){
            stringBuffer.add(hours+"h ");
        }
        if (totalMinutes > 0){
            stringBuffer.add(totalMinutes+" m ");
        }
        if (totalSeconds > 0){
            stringBuffer.add(totalSeconds+" s ");
        }
        if (totalMilliseconds > 0){
            stringBuffer.add(totalMilliseconds+" ms");
        }
        return stringBuffer.toString();
    }

    private String convertNanoToTime(long currentTimeNanos) {

        long nanoseconds = currentTimeNanos;

        // Konversi nanodetik ke jam, menit, detik, milidetik, dan nanodetik
        long seconds = nanoseconds / 1_000_000_000;
        nanoseconds %= 1_000_000_000;

        long minutes = seconds / 60;
        seconds %= 60;

        long hours = minutes / 60;
        minutes %= 60;

        long milliseconds = nanoseconds / 1_000_000;
        nanoseconds %= 1_000_000;


        /*long totalMilliseconds = currentTimeMillis % 1000;
        long totalSeconds = (currentTimeMillis / 1000) % 60;
        long totalMinutes = (currentTimeMillis / 60000) % 60;
        long hours = (currentTimeMillis / 3600000);*/
        StringJoiner stringBuffer = new StringJoiner("");

        if (hours > 0){
            stringBuffer.add(hours+"h ");
        }
        if (minutes > 0){
            stringBuffer.add(minutes+" m ");
        }
        if (seconds > 0){
            stringBuffer.add(seconds+" s ");
        }
        if (milliseconds > 0){
            stringBuffer.add(milliseconds+" ms ");
        }
        if (nanoseconds > 0){
            stringBuffer.add(nanoseconds+" ns ");
        }
        return stringBuffer.toString();
    }
}
