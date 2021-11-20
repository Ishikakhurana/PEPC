import java.util.*;
public class Main {
    public static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(){

        }
        Edge(int src,int nbr,int wt){
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;

        }
    }
    public static void display(ArrayList<Edge>[]graph){
        for(int i=0;i<graph.length;i++){
            System.out.print(i+" -> ");
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                System.out.print(e.src+" - "+e.nbr+" @ "+e.wt+" , ");
            }
            System.out.println();
        }
    }
    public static void addEdge(ArrayList<Edge>[]graph,int v1,int v2,int wt){
        Edge e1=new Edge(v1,v2,wt);
        Edge e2=new Edge(v2,v1,wt);

        graph[v1].add(e1);
        graph[v2].add(e2);

    }
    public static void main(String[] args){
      int v=7;
      ArrayList<Edge>[]graph=new ArrayList[v];
      for(int i=0;i<v;i++){
graph[i]=new ArrayList<>();
      }
      addEdge(graph,0,1,10);
        addEdge(graph,0,3,40);
        addEdge(graph,1,2,10);
        addEdge(graph,2,3,10);
        addEdge(graph,3,4,2);
        addEdge(graph,4,5,6);
        addEdge(graph,4,6,3);
        addEdge(graph,5,6,3);
        display(graph);
  }  
}
