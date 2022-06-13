class Solution {
    public String smallestSubsequence(String s, int k, char c, int r) {
        
        int cnt = 0, len = s.length(), cst = 0;
        for(int i = 0; i < len; i++) if(s.charAt(i) == c) cnt++;
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < len; i++){

            char ch = s.charAt(i);
            
            while(!st.isEmpty() && st.peek() > ch &&
                  len - i + st.size() > k &&
                  (cst + cnt > r || st.peek() != c)
                 ){
                char x = st.peek();
                st.pop();
                if(x == c) cst--;
            }
            
            if (st.size() < k && (ch == c || st.size() - cst < k - r)){
                st.push(ch); 
                if (ch == c) cst++;
            }
            if (ch == c) cnt--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char e = st.pop();
            sb.append(e);
        }
        return sb.reverse().toString();
    }
}