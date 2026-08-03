import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build the adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : times) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // 2. Track shortest distances
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);

        boolean[] inQueue = new boolean[n + 1];
        inQueue[k] = true;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            inQueue[currNode] = false;

            for (int[] neighbor : graph.get(currNode)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (dist[currNode] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[currNode] + weight;

                    if (!inQueue[nextNode]) {
                        queue.offer(nextNode);
                        inQueue[nextNode] = true;
                    }
                }
            }
        }

        // 5. Aggregate final result
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Node is unreachable
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }

        return maxDelay;
    }
}
