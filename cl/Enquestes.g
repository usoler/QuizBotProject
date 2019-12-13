grammar Enquestes;

root : (statement)*  END ;

statement : (pregunta | resposta | item | alternativa | enquesta) ;

pregunta : P IS WS PREGUNTA NL phrase NL ;

phrase : CAPITAL? (WORD (WS|INTERROGANTE))+ ;

resposta : R IS WS RESPOSTA NL (option)+ ;

option : NUM IS WS (CAPITAL? WORD WS)+ POINTCOMA NL ;

item : I IS WS ITEM NL P WS TO WS R NL ;

alternativa : A IS WS ALTERNATIVA NL I WS OPENCLAUDATOR (detour)+ CLOSECLAUDATOR NL ;

detour : OPENPARENT NUM COMA I CLOSEPARENT COMA? ;

enquesta : E IS WS ENQUESTA NL (I WS?)+ NL;

NUM : [0-9]+ ;
P : 'P'[0-9]+ ;
R : 'R'[0-9]+ ;
I : 'I'[0-9]+ ;
A : 'A'[0-9]+ ;
E : 'E' ;
IS : ':' ;
TO : '->' ;
PREGUNTA : 'PREGUNTA' ;
RESPOSTA : 'RESPOSTA' ;
ITEM : 'ITEM' ;
ALTERNATIVA : 'ALTERNATIVA' ;
ENQUESTA : 'ENQUESTA' ;
CAPITAL : [A-Z] ;
WORD : [a-z]+ ;
INTERROGANTE : '?' ;
POINTCOMA : ';' ;
COMA : ',' ;
OPENCLAUDATOR : '[' ;
CLOSECLAUDATOR : ']' ;
OPENPARENT : '(' ;
CLOSEPARENT : ')' ;
WS : ' ' ;
NL : '\n' ;
END : 'END' ;