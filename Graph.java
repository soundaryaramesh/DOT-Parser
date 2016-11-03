import java.util.*;

public class Graph {
       boolean directed;
	   static int edgesCount=0,nodesCount=0;
       ArrayList<SimpleNode> nodes;
       ArrayList<Pair> edges;
       
       public Graph(){
           nodes=new ArrayList<SimpleNode>();
           edges=new ArrayList<Pair>();
       }
       
       public void addEdge(SimpleNode src,SimpleNode dest,boolean val){
           directed=val;
		   int flag=containsEdge(src,dest);
           Pair e=new Pair(src,dest);
           if(flag==0){
               edges.add(e);
			   edgesCount++;
               addSimpleNode(src);
               addSimpleNode(dest);
           }
       }

	   public int containsEdge(SimpleNode src,SimpleNode dest){

           int flag=0;
           Pair e=new Pair(src,dest);
		   Iterator<Pair> itr=edges.iterator();
           while(itr.hasNext()){
               Pair element=itr.next();
               if(equalEdges(element,e)){
                   flag=1;
               }
           }
		   return flag;	

      } 
       public void addSimpleNode(SimpleNode n){
           boolean present=false;
           for (SimpleNode element : nodes) {
               if(element.equals(n)){
               		present=true;
			   }
           }
		   	if(!present){
               nodes.add(n);
			   nodesCount++;
			}
       }
       
       public boolean equalEdges(Pair a,Pair b){
		   	boolean one_dir= ((a.first).equals(b.first)&&((a.second).equals(b.second)));
           if(directed){
           		return one_dir;
		   }
		   else{
		   		boolean rev_dir=((a.first).equals(b.second)&&((a.second).equals(b.first)));
		   		return one_dir||rev_dir;
       		}
		}
       
       public void printGraph(){
		 System.out.println("\n\nTotal number of nodes are "+nodesCount);
		 System.out.println("Nodes are:");
		   for(SimpleNode n: nodes){
		   	   System.out.print(n.name+" ");
			}
		   System.out.println("\n\nTotal number of edges are "+edgesCount);
           if(edgesCount!=0){
		   if(directed)
		   System.out.println("Directed Edges are:");
           else
		   System.out.println("Undirected Edges are:");
		   for(Pair edge: edges){
               System.out.println(edge.first.name+" -- "+edge.second.name);
           }
		   }
       }
       
   }

