class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        HashMap<String, String> happened = new HashMap<>();
        Queue<String> children = new LinkedList<>();
        children.add("0000");
        while (!children.isEmpty()) {
            String current = children.poll();
            if (current.equals(target)) {
                return calculateCost(happened, target);
            }            
            if (deadendSet.contains(current))
                continue;

            for (int i = 0; i < 4; i++) {
                createChildren(children, happened, i, current);
            }
        }
        return -1;
    }
    void createChildren (Queue<String> children, HashMap<String, String> happened, int i,
                         String current) {
        int num = Integer.parseInt(current.substring(i, i+1));
        // Increment the lock
        num = (num + 1)  % 10;
        String temp = current.substring(0, i) +Integer.toString(num) + current.substring(i+1);
        if (!happened.containsKey(temp)) {
            children.add(temp);
            happened.put(temp, current);
        }
        // Decrement the lock
        num = (num - 2 + 10)  % 10;
        temp = current.substring(0, i) +Integer.toString(num) + current.substring(i+1);
        if (!happened.containsKey(temp)) {
            children.add(temp);
            happened.put(temp, current);
        }
    }
    int calculateCost(HashMap<String, String> happened, String target) {
        int cost = 0;
        while (!target.equals("0000")) {
            cost++;
            target = happened.get(target);
        }
        return cost;
    }
}
