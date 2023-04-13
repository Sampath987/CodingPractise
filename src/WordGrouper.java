import java.util.*;

public class WordGrouper {
    public static void main(String[] args) {
        String[] words = {"eat", "ate", "tea", "tan", "bat", "nat"};

        Map<String, List<String>> groups = new HashMap<>();
        // Alternatively, you can use TreeMap for ordered keys.

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            groups.get(key).add(word);
        }

        for (List<String> group : groups.values()) {
            System.out.println(group);
        }
    }
}


