/* Generated By:JJTree: Do not edit this line. ASTnode_id.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTnode_id extends SimpleNode {
  public ASTnode_id(int id) {
    super(id);
  }

  public ASTnode_id(DotParser p, int id) {
    super(p, id);
  }

  public void setName(String n){
      name=n;
  }
  public String toString(){
      return "Node: "+name;
  }
  /** Accept the visitor. **/
  public Object jjtAccept(DotParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

}
/* JavaCC - OriginalChecksum=993216428f07ac4ad7fdbac10d72bae0 (do not edit this line) */
