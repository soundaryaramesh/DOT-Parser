/*
 * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
   * and open the template in the editor.
    */

/**
 *
  * @author soundaryaramesh
   */
   public class DotParserEdgeVisitor implements DotParserVisitor{
   private int indent=0;

   Graph g=null;

        
        
	public Object visit(SimpleNode node,Object data){
            throw new RuntimeException("Visit SimpleNode");
	}
        
        public Object visit(ASTStart node,Object data){
           	g=new Graph(); 
            data=node.childrenAccept(this,data);
			g.printGraph();
            return g;
        }
        
        public Object visit(ASTdirectedEdge node,Object data){
            int children=node.jjtGetNumChildren();
            int i=0;
			SimpleNode src=(SimpleNode)((node.jjtGetChild(i)).jjtAccept(this,data));
            for(i=1;i<children;i++){
				
                SimpleNode dest=(SimpleNode)((node.jjtGetChild(i)).jjtAccept(this,data));
				g.addEdge(src,dest,true);
				src=dest;
            }
            return node;
        }
        
        public Object visit(ASTgraph_id node,Object data){
            data=node.childrenAccept(this,data);
            return node;
        }
        
        public Object visit(ASTnode_id node,Object data){
            Node parent=node.jjtGetParent();
			if(parent instanceof ASTgraph || parent instanceof ASTdigraph){
				g.addSimpleNode(node);				
			}
            data=node.childrenAccept(this,data);
            return node;
        }
        
        public Object visit(ASTdigraph node,Object data){
            data=node.childrenAccept(this,data);
            return data;
        }
        
        public Object visit(ASTgraph node,Object data){
            data=node.childrenAccept(this,data);
            return data;
        }
        
        public Object visit(ASTundirectedEdge node,Object data){
            int children=node.jjtGetNumChildren();
            int i=0;
			SimpleNode src=(SimpleNode)((node.jjtGetChild(i)).jjtAccept(this,data));
            for(i=1;i<children;i++){
                SimpleNode dest=(SimpleNode)((node.jjtGetChild(i)).jjtAccept(this,data));
                g.addEdge(src,dest,false);
				src=dest;
            }
            return node;
        }
}

