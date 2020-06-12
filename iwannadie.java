public int[] DIEjsktra(int[][] bootyMap, int me){
    int vertices = bootyMap.length;

    int[] dist = new int[vertices];
    boolean[] visited = new boolean[vertices];

    Arrays.fill(dist, Integer.MAX_VALUE);
    Arrays.fill(visited, false);

    dist[me] = 0;

    for(int i = 0; i < vertices-1; i++){
        int p = getMinIndex(dist, visited);

        visited[p] = true;

        for(int j = 0; j < vertices; j++){
            if(!visited[j] && bootyMap[p][j] != 0 &&
            dist[p] != Integer.MAX_VALUE && dist[p] + bootyMap[p][j] < dist[j]){
                dist[j] = dist[p] + bootyMap[p][j];
            }
        }
    }
}

public int getMinIndex(int[] dist, boolean[] visited){
    int vertices = dist.length;

    int minDist = Integer.MAX_VALUE;
    int minIndex = -1;

    for(int i = 0; i < vertices; i++){
        if(!visited[i] && dist[i] <= minDist){
            minDist = dist[i];
            minIndex = i;
        }
    }

    return minIndex;
}
