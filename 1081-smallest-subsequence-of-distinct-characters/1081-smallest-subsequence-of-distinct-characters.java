class Solution {
    public String smallestSubsequence(String s) {
        int[] li = new int[26];
        for(int i = 0; i < s.length(); i++)
            li[s.charAt(i) - 'a'] = i;
        boolean[] bool = new boolean[26];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            if(bool[c]) continue;
            while(!st.isEmpty() && st.peek() > c && i < li[st.peek()])
                bool[st.pop()] = false;
            st.push(c);
            bool[c] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append((char)(st.pop() +'a'));
        }
        return sb.reverse().toString();
    }
}