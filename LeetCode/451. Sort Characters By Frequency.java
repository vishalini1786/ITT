import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        // Step 1: Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create buckets where index = frequency
        int n = s.length();
        List<Character>[] buckets = new List[n + 1];

        // Step 3: Map characters to their respective frequency buckets
        for (char key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        // Step 4: Traverse buckets from highest to lowest frequency to build result
        StringBuilder sb = new StringBuilder();
        for (int pos = buckets.length - 1; pos >= 1; pos--) {
            if (buckets[pos] != null) {
                for (char c : buckets[pos]) {
                    // Append the character 'pos' times (its frequency)
                    for (int i = 0; i < pos; i++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
