//ε
lexer grammar ScannerSS4;
//Expresiones regulares
//Simbolos

PyCOMA:';';
COMA: ',';
ASSIGN: '=';
PIZQ: '(';
PDER: ')';
DPTS: ':';
RDC: '~';
SUM: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MAYOR: '>';
MENOR: '<';
MAYOREQ: '>=';
MENOREQ: '<=';
EQU: '==';
PCI: '[';
PCD:']';
LLIZQ: '{';
LLDER: '}';
DOBSLA: '//';
INICOME: '/*';
FINCOME: '*/';


//Asignaciones
IF : 'if'|'IF';
LET: 'let'|'LET';
ELSE: 'else'|'ELSE';
TRUE: 'true'|'TRUE';
FALSE: 'false'|'FALSE';
LEN: 'len'|'LEN';
FIRST: 'first'|'FIRST';
LAST: 'last'|'LAST';
REST: 'rest'|'REST';
PUSH: 'push' |'PUSH';
FUN: 'fun'|'FUN';
PUTS: 'puts'|'PUTS';



ID: LETTER(LETTER|DIGIT)*;
NUM: DIGIT DIGIT*;
RETURN: 'return'|'RETURN';
STRING: '"' CARAC*? '"';
BOOL: TRUE | FALSE;
CHAR: '\'' ( LETTER | DIGIT ) '\'';

CARAC: ( LETTER | DIGIT );


COMMENT : INICOME (COMMENT|.)*? FINCOME -> channel(HIDDEN) ;
LINE_COMMENT  : DOBSLA .*? '\n' -> channel(HIDDEN) ;


fragment LETTER :'a'..'z' | 'A'..'Z' | '_';
fragment DIGIT :'0'..'9';

//+ 0 * =una o mas veces
WS:[ \t\n\r]+-> skip;
