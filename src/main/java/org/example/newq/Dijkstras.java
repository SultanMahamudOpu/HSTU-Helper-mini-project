package org.example.newq;

import java.util.*;

public class Dijkstras {
    public static int parent[]=new int[10000];
    static class Edge {

        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 300));
        graph[0].add(new Edge(0, 2, 300));
        graph[1].add(new Edge(1, 3, 20));
        graph[1].add(new Edge(1, 2, 200));
        graph[2].add(new Edge(2, 4, 400));
        graph[3].add(new Edge(3, 5, 300));
        graph[4].add(new Edge(4, 3, 50));
        graph[4].add(new Edge(4, 5, 400));
        graph[0].add(new Edge(0, 5, 200));
        graph[0].add(new Edge(0, 3, 400));
        graph[0].add(new Edge(0, 4, 1000));
        graph[1].add(new Edge(1, 4, 100));



        graph[1].add(new Edge(1, 0, 300));
        graph[2].add(new Edge(2, 0, 300));
        graph[3].add(new Edge(3, 1, 20));
        graph[2].add(new Edge(2, 1, 200));
        graph[4].add(new Edge(4, 2, 400));
        graph[5].add(new Edge(5, 3, 300));
        graph[3].add(new Edge(3, 4, 50));
        graph[5].add(new Edge(5, 4, 400));
        graph[5].add(new Edge(5, 0, 200));
        graph[3].add(new Edge(3, 0, 400));
        graph[4].add(new Edge(4, 0, 1000));
        graph[4].add(new Edge(4, 1, 100));

    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void  dijkstra(ArrayList<Edge> graph[], int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if (!vis[v] && dist[u] + e.wt < dist[v]) {
                        dist[v] = dist[u] + e.wt;
                        parent[v]=u;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
    }

    public ArrayList<String> reverseArrayList(ArrayList<String> alist)
    {
        // Arraylist for storing reversed elements
        ArrayList<String> revArrayList = new ArrayList<String>();
        for (int i = alist.size() - 1; i >= 0; i--) {

            // Append the elements in reverse order
            revArrayList.add(alist.get(i));
        }

        // Return the reversed arraylist
        return revArrayList;
    }

    public String printElements(ArrayList<String> alist)
    {
        String st = "";
        for (int i = 0; i < alist.size(); i++) {
//            System.out.print(alist.get(i) + " ");
            st+=alist.get(i);
            if(i!=alist.size()-1){
                st+=" --> ";
            }
        }
        return st;
    }


    public  String numberToString(int n){
        if(n==0){
            return "MAIN GATE";
        }if(n==1){
            return "M.A.WAZE";
        }if(n==2){
            return "TSC";
        }if(n==3){
            return "AGRICULTURE";
        }if(n==4){
            return "BUS STAND";
        }if(n==5){
            return "DVM";
        }if(n==6){
            return "K.K.BUILDING";
        }if(n==7){
            return "LIBRARY";
        }
        return "Path can't find";
    }


    public static String start() {
        Scanner sc=new Scanner(System.in);
        Dijkstras obj = new Dijkstras();
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
//        System.out.print("Enter src: ");
        System.out.println(FindSrcDst.setSrc()+" "+FindSrcDst.setDst());
        int src = FindSrcDst.setSrc();
        dijkstra(graph, src);

//        System.out.print("Enter dst: ");
        int dist=FindSrcDst.setDst();

        int currentNode = dist;

        ArrayList<String> path=new ArrayList<String>();

        while (true)
        {

            path.add(obj.numberToString(currentNode));
            if (currentNode == src)
            {
                break;
            }

            currentNode = parent[currentNode];
        }

        path = obj.reverseArrayList(path);
        String st=obj.printElements(path);
//        System.out.println(st);
        return  st;
    }

}




/*
0 1 2
0 2 4
1 3 7
1 2 1
2 4 3
3 5 1
4 3 2
4 5 5
 */