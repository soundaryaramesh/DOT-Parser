   
   public class DotParserOptimizerVisitor implements DotParserVisitor{
   Graph g=null;

        
        
	public Object visit(SimpleNode node,Object data){
            throw new RuntimeException("Visit SimpleNode");
	}
        
        public Object visit(ASTStart node,Object data){
           	g=new Graph(); 
			node.childrenAccept(this,null);
			return data;
        }
        
        public Object visit(ASTdirectedEdge node,Object data){
            int no_children=node.jjtGetNumChildren();
            int i=0;
			SimpleNode src=(SimpleNode)((node.jjtGetChild(i)).jjtAccept(this,data));
            for(i=1;i<node.jjtGetNumChildren();i++){
				
                SimpleNode dest=(SimpleNode)((node.jjtGetChild(i)).jjtAccept(this,data));
				if(g.containsEdge(src,dest)==1)
				{
					int new_children=node.jjtGetNumChildren()-1;
					i--;
					if(i==0){
						SimpleNode c[] = new SimpleNode[new_children];
						for(int j=i;j<new_children;j++){
							node.children[j]=node.children[j+1];
						}
						System.arraycopy(node.children,0,c,0,new_children);
						node.children=c;
					}
					if(i==new_children-1){
						//new_children--;
						if(new_children==0||new_children==1){
							node.children=null;
						}
						else{
							SimpleNode d[]=new SimpleNode[new_children];
							System.arraycopy(node.children,0,d,0,new_children);
							node.children=d;
						}
					}
				}
				else{
					g.addEdge(src,dest,true);
				}

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
			for(int i=0;i<node.jjtGetNumChildren();i++){
				Node child=node.jjtGetChild(i);
				if(child.jjtGetNumChildren()==0&&(child instanceof ASTdirectedEdge)){
					int new_children=node.jjtGetNumChildren()-1;
                    SimpleNode c[] = new SimpleNode[new_children];
                    for(int j=i;j<new_children;j++){
                        node.children[j]=node.children[j+1];
                    }   
					i--;
                    System.arraycopy(node.children,0,c,0,new_children);
                    node.children=c;
				}
			}
            return data;
        }
        
        public Object visit(ASTgraph node,Object data){
            data=node.childrenAccept(this,data);
			for(int i=0;i<node.jjtGetNumChildren();i++){
				Node child=node.jjtGetChild(i);
				if(child.jjtGetNumChildren()==0&&(child instanceof ASTundirectedEdge)){
					int new_children=node.jjtGetNumChildren()-1;
                    SimpleNode c[] = new SimpleNode[new_children];
                    for(int j=i;j<new_children;j++){
                        node.children[j]=node.children[j+1];
                    }   
                    i--;
                    System.arraycopy(node.children,0,c,0,new_children);
                    node.children=c;
				}
			}
            return data;
        }
        
        public Object visit(ASTundirectedEdge node,Object data){
            int no_children=node.jjtGetNumChildren();
            int i=0;
			SimpleNode src=(SimpleNode)((node.jjtGetChild(i)).jjtAccept(this,data));
            for(i=1;i<node.jjtGetNumChildren();i++){
				
                SimpleNode dest=(SimpleNode)((node.jjtGetChild(i)).jjtAccept(this,data));
				if(g.containsEdge(src,dest)==1)
				{
					int new_children=node.jjtGetNumChildren()-1;
					i--;
					if(i==0){
						SimpleNode c[] = new SimpleNode[new_children];
						for(int j=i;j<new_children;j++){
							node.children[j]=node.children[j+1];
						}
						System.arraycopy(node.children,0,c,0,new_children);
						node.children=c;
					}
					if(i==new_children-1){
						//new_children--;
						if(new_children!=0&&new_children!=1){
							SimpleNode d[]=new SimpleNode[new_children];
							System.arraycopy(node.children,0,d,0,new_children);
							node.children=d;
						}
						else{
							node.children=null;
						}
					}
				}
				else{
					g.addEdge(src,dest,false);
				}

				src=dest;
            }
			return node;
	}
}

