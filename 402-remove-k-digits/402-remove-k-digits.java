class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            char s = num.charAt(i);
            while(!st.isEmpty() && st.peek() > s && k > 0){
                st.pop();
                k--;
            }
            st.push(s);
        }
        
        while(k>0){
            st.pop();
            k--;
        }
        char[] arr = new char[st.size()];
        int i = arr.length - 1;
        while(i >= 0)arr[i--] = st.pop();
        
        int d=0;
        while(d < arr.length && arr[d] == '0')d++;
        
        StringBuilder sb = new StringBuilder();
        while(d<arr.length)
            sb.append(arr[d++]);
        if(sb.length() == 0) sb.append('0');
        return sb.toString();
    }
}