// https://leetcode.com/problems/number-of-provinces/
class DFSandBFS {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean [] pushed = new boolean[n];

        Stack<Integer> stack = new Stack<Integer>(); // Queue
        int k = 0;
        int p = 0;
        while(k<n){
            for(int i=0;i<n;i++)
            if (pushed[i]==false){
                stack.push(i);
                pushed[i] = true;
                p++;
                break;
            }

            while(stack.empty()==false){
                int v = stack.pop();
                k = k + 1;

                for(int i=0;i<n;i++){
                    if (isConnected[v][i]==1 && !pushed[i]){
                        stack.push(i);
                        pushed[i] = true;
                    }
                }
            }
        }
        return p;
    }
}
