class Solution {
      private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
      }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
         PriorityQueue<Project> cap = new PriorityQueue<>((x, y) -> x.capital-y.capital);
         PriorityQueue<Project> proj= new PriorityQueue<>((x, y) -> y.profit-x.profit);
         int n=profits.length;
         for(int i=0;i<n;i++) cap.offer(new Project(capital[i],profits[i]));
         for(int i=1;i<=k;i++){
            while(!cap.isEmpty()&&cap.peek().capital<=w){
                proj.add(cap.poll());
            }
            if(proj.isEmpty())return w;
            else w+=proj.poll().profit;
         }
         return w;

    }
}