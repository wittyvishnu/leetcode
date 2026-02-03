class Solution {
PriorityQueue<Integer> max =new PriorityQueue<>(Collections.reverseOrder());
PriorityQueue<Integer> min =new PriorityQueue<>();
HashMap<Integer, Integer> delayed = new HashMap<>();
int maxSize = 0;
int minSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        double[] ans=new double[n-k+1];
        for(int i=0;i<n;i++){
            if(i>=k)remove(nums[i-k]);
            add(nums[i]);
            if(i>=k-1) ans[i-k+1]=getMedian();
        }
        return ans;
    }
    public void add(int num){
        if (max.isEmpty() || num <= max.peek()) {
        max.offer(num);
        maxSize++;
    } else {
        min.offer(num);
        minSize++;
    }
    balance();

    }
    public void balance() {
    if (maxSize > minSize + 1) {
        min.offer(max.poll());
        maxSize--;
        minSize++;
        prune(max);
    }
    else if (maxSize < minSize) {
        max.offer(min.poll());
        minSize--;
        maxSize++;
        prune(min);
    }
}

    public void  remove(int num) {
    delayed.put(num, delayed.getOrDefault(num, 0) + 1);
    if (num <= max.peek())maxSize--;
    else minSize--;
    prune(max);
    prune(min);
    balance();
}

    public double getMedian() {
    if (maxSize!=minSize)
        return max.peek();
    return ((double) max.peek() + min.peek()) / 2.0;
}

    void prune(PriorityQueue<Integer> heap) {
    while (!heap.isEmpty()) {
        int top = heap.peek();
        if (delayed.containsKey(top)) {
            delayed.put(top, delayed.get(top) - 1);
            if (delayed.get(top) == 0)
                delayed.remove(top);
            heap.poll();
        } else break;
    }
}

}