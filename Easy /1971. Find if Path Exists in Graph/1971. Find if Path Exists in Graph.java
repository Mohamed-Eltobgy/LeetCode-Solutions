class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];

        return dfs(adjList, visited, source, destination);
    }
    
    boolean dfs(List<List<Integer>> graph, boolean[] visited, int source, int destination) {
        if (source == destination)
            return true;
        visited[source] = true;
        for (int neighbour : graph.get(source)) {
            if (!visited[neighbour]) {
                if (dfs(graph, visited, neighbour, destination))
                    return true;
            }
        }
        return false;
    }
}
