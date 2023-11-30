import java.util.ArrayList;
import java.util.List;

public class MemoryLeakExample {
    private static final List<Object> objects = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            // Menyimpan referensi objek ke dalam list tanpa membersihkan
            objects.add(new Object());
        }
    }
}