sourcefiles = DotParser.java
classfiles=$(sourcefiles:.java=.class)

all: DotParser.java $(classfiles)

%.class: %.java 
	javac $<

DotParser.java: DotParser.jj
	javacc DotParser.jj

DotParser.jj:
	jjtree DotParser.jjt

clean:
	rm *.class *.jj ASTStart.java ASTdigraph.java ASTdirectedEdge.java ASTgraph.java ASTundirectedEdge.java DotParser.java DotParserConstants.java DotParserTokenManager.java DotParserTreeConstants.java DotParserVisitor.java JJTDotParserState.java Node.java ParseException.java SimpleCharStream.java Token.java TokenMgrError.java

	
