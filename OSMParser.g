parser grammar OSMParser;
options {
    tokenVocab=OSMLexer;
    output=AST;
}

tokens {
    ELEMENT;
    ATTRIBUTE;
}

document : declaration! element^ ;

element
    : ( startTag^ (element | PCDATA )* endTag!
    | emptyElement )
    ;

declaration! : TAG_DECLARATION_OPEN GENERIC_ID attribute* TAG_DECLARATION_CLOSE ;

startTag : TAG_START_OPEN GENERIC_ID attribute* TAG_CLOSE
        -> ^(ELEMENT GENERIC_ID attribute*)
    ;

attribute : GENERIC_ID ATTR_EQ ATTR_VALUE -> ^(ATTRIBUTE GENERIC_ID ATTR_VALUE) ;

endTag! : TAG_END_OPEN GENERIC_ID TAG_CLOSE;

emptyElement : TAG_START_OPEN GENERIC_ID attribute* TAG_EMPTY_CLOSE
        -> ^(ELEMENT GENERIC_ID attribute*)
    ;
