# Implementation of Parser for DOT language using JavaCC
Involves building a lexer, parser and abstract syntax trees(AST).<br />
Three types of visitors have been implemented using the Visitor Design Pattern <br />
**PrintVisitor**, which prints the AST by depth-first traversal of the tree <br />
**EdgeVisitor**, which discovers the edge relationships and new nodes from the AST and stores them in ArrayLists. <br />
**OptimizerVisitor**, which removes the redundant edges from the AST whenever possible.

##Usage
Run the Makefile as follows to obtain all the .class files
### make
Run the following command to obtain the parser
### java DotParser
To remove all the additional files created during the process
### make clean


##Tests
A sample DOT language graph is present in the file *test.in*
### java DotParser \< test.in 



