import java.util.Vector;

public class Vectors {
    public static Object fold(Vector l, Object initial, PlusObject PO) {
        Object result = initial;
        for (int i = 0; i < l.size(); i++) {
            result = PO.apply(result, l.get(i));
        }
        return result;
    }
}
