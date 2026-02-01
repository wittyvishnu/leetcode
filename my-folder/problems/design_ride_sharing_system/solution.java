class RideSharingSystem {
    LinkedList<Integer> rider;
    Queue<Integer> driver;
    public RideSharingSystem() {
        rider = new LinkedList<>();
        driver=new ArrayDeque<>();
    }
    
    public void addRider(int riderId) {
        rider.addLast(riderId);
    }
    
    public void addDriver(int driverId) {
        driver.offer(driverId);
    }
    
    public int[] matchDriverWithRider() {
        int[] ans=new int[2];
        if(rider.peekFirst() != null &&!driver.isEmpty()){
            ans[0]=driver.poll();
            ans[1]=rider.removeFirst();
        }
        else{
            ans[0]=ans[1]=-1;
        }
        return ans;
    }
    
    public void cancelRider(int riderId) {
        rider.remove(Integer.valueOf(riderId));
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */