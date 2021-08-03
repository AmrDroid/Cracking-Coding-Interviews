package amazon;

import java.util.*;

public class LeastFrequentlyUsed {

    private static final int DEFAULT_MAX_SIZE = 3;
    private int capacity = DEFAULT_MAX_SIZE;
    //Save cache access frequency and time
    private final Map<Integer, HitRate> cache = new HashMap<Integer, HitRate>();
    //Save cached KV
    private final Map<Integer, Integer> KV = new HashMap<Integer, Integer>();

    // @param capacity, an integer
    public LeastFrequentlyUsed(int capacity) {
        this.capacity = capacity;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        Integer v = KV.get(key);
        if (v == null) {
            if (cache.size() == capacity) {
                Integer k = getKickedKey();
                KV.remove(k);
                cache.remove(k);
            }
            cache.put(key, new HitRate(key, 1, System.nanoTime()));
        } else { //If the keys are the same, only increase the frequency, update time, and do not replace
            HitRate hitRate = cache.get(key);
            hitRate.hitCount += 1;
            hitRate.lastTime = System.nanoTime();
        }
        KV.put(key, value);
    }

    public int get(int key) {
        Integer v = KV.get(key);
        if (v != null) {
            HitRate hitRate = cache.get(key);
            hitRate.hitCount += 1;
            hitRate.lastTime = System.nanoTime();
            return v;
        }
        return -1;
    }
    // @return the key to be replaced
    private Integer getKickedKey() {
        HitRate min = Collections.min(cache.values());
        return min.key;
    }

    class HitRate implements Comparable<HitRate> {
        Integer key;
        Integer hitCount; // Number of hits
        Long lastTime; // Last hit time

        public HitRate(Integer key, Integer hitCount, Long lastTime) {
            this.key = key;
            this.hitCount = hitCount;
            this.lastTime = lastTime;
        }

        public int compareTo(HitRate o) {
            int hr = hitCount.compareTo(o.hitCount);
            return hr != 0 ? hr : lastTime.compareTo(o.lastTime);
        }
    }

    public static void main(String[] as) throws Exception {
        LeastFrequentlyUsed cache = new LeastFrequentlyUsed(3);
        cache.set(2, 2);
        cache.set(1, 1);

        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

        cache.set(3, 3);
        cache.set(4, 4);

        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));

    }

}
