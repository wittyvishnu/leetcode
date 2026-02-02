class Pair {
    char first;
    int second;

    Pair(char first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public String reorganizeString(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> b.second - a.second);

        for (char ch : map.keySet()) {
            pq.offer(new Pair(ch, map.get(ch)));
        }

        StringBuilder ans = new StringBuilder();

        // TAKE TWO AT A TIME
        while (pq.size() > 1) {
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();

            ans.append(p1.first);
            ans.append(p2.first);

            p1.second--;
            p2.second--;

            if (p1.second > 0) pq.offer(p1);
            if (p2.second > 0) pq.offer(p2);
        }

        // Handle last character
        if (!pq.isEmpty()) {
            if (pq.peek().second > 1) return "";
            ans.append(pq.poll().first);
        }

        return ans.toString();
    }
}
