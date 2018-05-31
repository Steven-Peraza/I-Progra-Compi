parser grammar ParserUI;

options {
    tokenVocab = ScannerSS4;
}



program  		: statement*                                                                #programAST
;
statement  	: LET letStatement                                                              #statementLET
            | RETURN returnStatement                                                        #statementRETURN
            | expressionStatement                                                           #statementEXPRESSION
;
letStatement locals [int storageIndex=0]: identifier ASSIGN expression ( PyCOMA | )                                 #letAST
;
returnStatement	: expression ( PyCOMA | )                                                   #returnAST
;
expressionStatement 	: expression ( PyCOMA | )                                           #expressionStatementAST
;
expression             	: additionExpression comparison                                     #expressionAST
;
comparison            	: ((MENOR|MAYOR|MENOREQ|MAYOREQ|EQU) additionExpression)*           #comparisonAST
;
additionExpression	: multiplicationExpression additionFactor                               #additionExpressionAST
;
additionFactor       	: ((SUM|SUB) multiplicationExpression)*                             #addfactorAST
;
multiplicationExpression : elementExpression multiplicationFactor                           #multiplicationExpressionAST
;
multiplicationFactor	: ((MUL|DIV) elementExpression)*                                    #multifactorAST
;
elementExpression 	: primitiveExpression (elementAccess | callExpression | )               #elementExpressionAST
;
elementAccess       	: PCI expression PCD                                                #elementAccessAST
;
callExpression	: PIZQ expressionList PDER                                                  #callExpressionAST
;
primitiveExpression:
                    NUM                                                                     #pExpNUM
                    | STRING                                                                #pExpSTRING
                    | identifier                                                            #pExpID
                    | TRUE                                                                  #pExpTRUE
                    | FALSE                                                                 #pExpFALSE
                    | PIZQ expression PDER                                                  #pExpEXPRESSION
                    | arrayLiteral                                                          #pExpARRAYLITE
                    | arrayFunctions PIZQ expressionList PDER                               #pExpARRAYFUNC
                    | functionLiteral                                                       #pExpFUNCLITE
                    | hashLiteral                                                           #pExpHASHLITE
                    | printExpression                                                       #pExpPRINT
                    | ifExpression                                                          #pExpIF
;
arrayFunctions	: LEN                                                                       #arrfunLEN
                | FIRST                                                                     #arrfunFIRST
                | LAST                                                                      #arrfunLAST
                | REST                                                                      #arrfunREST
                | PUSH                                                                      #arrfunPUSH
;
arrayLiteral    : PCI expressionList PCD                                                    #arrayLiteralAST
;
functionLiteral	: FUN PIZQ functionParameters PDER blockStatement                           #functionLiteralAST
;
functionParameters	: ID moreIdentifiers                                                    #functionParametersAST
;
identifier
locals [ParserRuleContext decl=null]
        : ID                                                                                #idAST
        ;
moreIdentifiers	: (COMA ID)*                                                                #moreIdentifiersAST
;
hashLiteral		: LLIZQ hashContent moreHashContent LLDER                                   #hashLiteralAST
;
hashContent	: expression DPTS expression                                                    #hashContentAST
;
moreHashContent	: (COMA hashContent)*                                                       #moreHashContentAST
;
expressionList       	: expression moreExpressions                                        #expressionListAST
                         |                                                                  #expressionListNULLAST
;
moreExpressions    	: (COMA expression)*                                                    #moreExpressionsAST
;
printExpression      	: PUTS PIZQ expression PDER                                         #printExpressionAST
;
ifExpression	: IF expression blockStatement (ELSE blockStatement | )                     #ifExpressionAST
;
blockStatement	: LLIZQ statement* LLDER                                                    #blockStatementAST
;

