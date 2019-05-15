package com.codility;

// you can also use imports, for example:
import java.util.*;
import org.junit.Test;
import org.junit.*;

public class Solution {

    public int main() {
        String str = "the morning sun rose above the distant mountains and it was beautiful";
        List<String> result = splitString(str, ' ', 10);
        
        return 0;
    }
    
    
    /**
     * Splits string on separator but also aheres to the character limit requirement
     * Used three pointers (start, mid, end) to walk the array and take a char count < 10
     * 
     * I'm sure there is a more succint way of doing this in regex
     * 
     * @return ArrayList of Strings 
     * */
    public List<String> splitString(String str, char separator, int limit) {
        
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }

        int charCount = 0; // character count
        int size = str.length();
        List<String> result = new ArrayList<>();


        int start = 0, mid = 0, end = 0; // keep three pointers to window the solution.
        while(end < size) {
            if (str.charAt(end) == separator && charCount < limit) {
                mid = end++;
                charCount++;
            } else if (charCount == limit) {
                result.add(str.substring(start, mid));
                start = mid + 1;
                end = mid + 1;
                charCount = 0;
            } else {
                end++;
                charCount++;
            }
        }

        //add the remainder
        result.add(str.substring(start, size));

        return result;
    }



    /** You can write unit tests here if you want! **/
    public static class Tests {
        @Test
        public void stringSplitTest() {
            String str = "the morning sun rose above the distant mountains and it was beautiful";
            List<String> expectedValue = new ArrayList(Arrays.asList("the", "morning", "sun rose", "above the", "distant", "mountains", "and it", "was", "beautiful"));
            List<String> result = new Solution().splitString(str, ' ', 10);
            Assert.assertArrayEquals(result.toArray(), expectedValue.toArray());
          
        }
        
        @Test
        public void stringSplitTestShort() {
            String str = "the";
            List<String> expectedValue = new ArrayList(Arrays.asList("the"));
            List<String> result = new Solution().splitString(str, ' ', 10);
            Assert.assertArrayEquals(result.toArray(), expectedValue.toArray());
          
        }
        
        @Test
        public void stringSplitTestEmpty() {
            String str = "";
            List<String> expectedValue = new ArrayList();
            List<String> result = new Solution().splitString(str, ' ', 10);
            Assert.assertArrayEquals(result.toArray(), expectedValue.toArray());
          
        }
        
        @Test
        public void stringSplitTestNull() {
            String str = null;
            List<String> expectedValue = new ArrayList();
            List<String> result = new Solution().splitString(str, ' ', 10);
            Assert.assertArrayEquals(result.toArray(), expectedValue.toArray());
          
        }
    }
}