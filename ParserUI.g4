parser grammar ParserUI;

options {
    tokenVocab = ScannerSS4;
}



program  		: statement*;
statement  	: LET letStatement | RETURN returnStatement | expressionStatement;
letStatement          	: ID ASSIGN expression ( PyCOMA | );
returnStatement	: expression ( PyCOMA | );
expressionStatement 	: expression ( PyCOMA | );
expression             	: additionExpression comparison;
comparison            	: ((MENOR|MAYOR|MENOREQ|MAYOREQ|EQU) additionExpression)*;
additionExpression	: multiplicationExpression additionFactor;
additionFactor       	: ((SUM|SUB) multiplicationExpression)*;
multiplicationExpression : elementExpression multiplicationFactor;
multiplicationFactor	: ((MUL|DIV) elementExpression)*;
elementExpression 	: primitiveExpression (elementAccess | callExpression | );
elementAccess       	: PCI expression PCD;
callExpression	: PIZQ expressionList PDER;
primitiveExpression	: NUM | STRING | ID | TRUE | FALSE | PIZQ expression PDER | arrayLiteral | arrayFunctions PIZQ expressionList PDER | functionLiteral | hashLiteral | printExpression | ifExpression;
arrayFunctions	: LEN | FIRST | LAST | REST | PUSH;
arrayLiteral        	: PCI expressionList PCD;
functionLiteral	: FUN PIZQ functionParameters PDER blockStatement;
functionParameters	: ID moreIdentifiers;
moreIdentifiers	: (COMA ID)*;
hashLiteral		: LLIZQ hashContent moreHashContent LLDER;
hashContent	: expression DPTS expression;
moreHashContent	: (COMA hashContent)*;
expressionList       	: expression moreExpressions | ;
moreExpressions    	: (COMA expression)*;
printExpression      	: PUTS PIZQ expression PDER;
ifExpression	: IF expression blockStatement (ELSE blockStatement | );
blockStatement	: LLIZQ statement* LLDER;

