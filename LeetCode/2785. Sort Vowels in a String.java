import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        List<Character> vowelsList = new ArrayList<>();
        
        // Step 1: Collect all vowels from the string
        for (char c : chars) {
            if (isVowel(c)) {
                vowelsList.add(c);
            }
        }
        
        // Step 2: Sort the vowels in non-decreasing ASCII order
        Collections.sort(vowelsList);
        
        // Step 3: Place the sorted vowels back into the vowel positions
        int vowelIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                chars[i] = vowelsList.get(vowelIndex);
                vowelIndex++;
            }
        }
        
        // Convert the character array back to a string
        return new String(chars);
    }
    
    // Helper function to check if a character is a vowel
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
