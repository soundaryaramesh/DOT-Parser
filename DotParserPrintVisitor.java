public class DotParserPrintVisitor implements DotParserVisitor{

	private int indent=0;
	private String indentString(){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<indent;i++){
			sb.append("  ");
		}
		return sb.toString();
	}
	
	public Object visit(SimpleNode node,Object data){
		throw new RuntimeException("visit simplenode");
	}

	public Object visit(ASTStart node,Object data){
		System.out.println(indentString()+node);
		++indent;
		data=node.childrenAccept(this,data);
		--indent;
		return data;
	}

	
	public Object visit(ASTgraph node,Object data){
		System.out.println(indentString()+node);
		++indent;
		data=node.childrenAccept(this,data);
		--indent;
		return data;
	}
	
	public Object visit(ASTdigraph node,Object data){
		System.out.println(indentString()+node);
		++indent;
		data=node.childrenAccept(this,data);
		--indent;
		return data;
	}


	public Object visit(ASTgraph_id node,Object data){
		System.out.println(indentString()+node);
		++indent;
		data=node.childrenAccept(this,data);
		--indent;
		return data;
	}


	public Object visit(ASTnode_id node,Object data){
		System.out.println(indentString()+node);
		++indent;
		data=node.childrenAccept(this,data);
		--indent;
		return data;
	}


	public Object visit(ASTundirectedEdge node,Object data){
		System.out.println(indentString()+node);
		++indent;
		data=node.childrenAccept(this,data);
		--indent;
		return data;
	}

	public Object visit(ASTdirectedEdge node,Object data){
		System.out.println(indentString()+node);
		++indent;
		data=node.childrenAccept(this,data);
		--indent;
		return data;
	}
}
