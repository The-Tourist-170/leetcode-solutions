class Solution {
    // refrence video link : https://youtu.be/SVW1bD_PN6A
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] res = new double[n];
        Arrays.fill(res, -1);       // no collision then -1 collision time
        
        Stack<Integer> stack = new Stack<>(); // to store indices 
        
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && cars[i][1] <= cars[stack.peek()][1])
                stack.pop();
            
            while(!stack.isEmpty()){
                double collisionTime = ( cars[i][0] - cars[stack.peek()][0] ) / (double) (cars[stack.peek()][1] - cars[i][1]);  // distance / relative speed
                if(collisionTime <= res[stack.peek()] || res[stack.peek()] == -1){              // actual collision time
                    res[i] = collisionTime;
                    break;
                }
                stack.pop();
            }
            
            stack.push(i);
        }
        
        return res;
    }
}