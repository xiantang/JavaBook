package BuildingBlocks;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class SafeVectorHelpers {
    public static Object getLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }
    }

    public static void deleteLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            list.remove(lastIndex);
//            ConcurrentHashMap
        }
    }
}
