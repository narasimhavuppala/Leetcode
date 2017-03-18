public class Solution2 {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0)return "";
        int n = s.length();
        //char[] vowels = new char[] {'a','e','i','o','u','A','E','I','O','U'};
        HashSet<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int start = 0, end = n-1;
        char[] sar = s.toCharArray();
        while(start < end){
            while(start<end && !set.contains(sar[start]))start++;
            while(start<end && !set.contains(sar[end]))end--;
            if(start<end){
                char temp = sar[start];
                sar[start] = sar[end];
                sar[end] = temp;
                start++;end--;
            }
        }
        
        return new String(sar);
    }
}