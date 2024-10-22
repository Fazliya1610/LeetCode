class Solution {
    public int largestRectangleArea(int[] heights) {
        int len=heights.length;
        int span=0,area=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<len;i++){
            if(st.isEmpty()||heights[i]>heights[st.peek()]){
                st.push(i);
            }else{
                while(!st.isEmpty()&&heights[i]<=heights[st.peek()]){
                    int val=heights[st.pop()];
                    if(st.isEmpty()){
                        span=i;
                    }
                    else{
                        span=i-1-st.peek();
                    }
                    area=Math.max(val*span,area);
                }
                st.push(i);
            }
        }
        while(!st.isEmpty()){
            int index=st.pop();
            if(st.isEmpty()){
                area=Math.max(area,heights[index]*len);
            }
            else{
                area=Math.max(heights[index]*(len-1-st.peek()),area);
            }
        }
        return area;
    }
}