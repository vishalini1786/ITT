import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        
        // Step 1: Sort words by length. 
        // Shorter words cannot be formed by longer words.
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        
        // Step 2: Process each word
        for (String word : words) {
            if (word.isEmpty()) continue;
            
            // Use a primitive Boolean array for ultra-fast memoization caching
            // memo[i] will track if the suffix starting at index i can be formed
            Boolean[] memo = new Boolean[word.length()];
            
            if (canForm(word, 0, wordSet, memo)) {
                result.add(word);
            }
            
            // Add the current word to the set *after* checking it.
            // This prevents a word from matching with itself!
            wordSet.add(word);
        }
        
        return result;
    }
    
    // Optimized DFS with Memoization
    private boolean canForm(String word, int start, Set<String> wordSet, Boolean[] memo) {
        // Base case: If we successfully reached the end of the string, it's valid
        if (start == word.length()) {
            return true;
        }
        
        // If we have already evaluated this suffix before, return the cached result
        if (memo[start] != null) {
            return memo[start];
        }
        
        // Try breaking the remaining suffix at every possible position
        for (int end = start + 1; end <= word.length(); end++) {
            String prefix = word.substring(start, end);
            
            // If the prefix exists in our set, recursively check the rest
            if (wordSet.contains(prefix)) {
                if (canForm(word, end, wordSet, memo)) {
                    return memo[start] = true; // Cache and return true
                }
            }
        }
        
        return memo[start] = false; // Cache and return false
    }
}
