package harmonicvalidator.utils;

import java.util.HashMap;

public class NoteToId {
    public static final HashMap<String, Integer> map;
    static{
        HashMap<String, Integer> amap = new HashMap<>();
        amap.put("C", 1);
        amap.put("D", 2);
        amap.put("E", 3);
        amap.put("F", 4);
        amap.put("G", 5);
        amap.put("A", 6);
        amap.put("B", 7);

        map = amap;
    }
}
