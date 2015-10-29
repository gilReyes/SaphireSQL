package lexicalanalyzer;
import static lexicalanalyzer.Token.*;
%%
%class Lexer
%type Token
L = [a-zA-Z_]
D = [0-9]
WHITE=[ \t\r\n]
%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}
<YYINITIAL> "QGen" {lexeme=yytext(); return QGENOP;}
<YYINITIAL> "display" {lexeme=yytext(); return DISPLAYOP;}
<YYINITIAL> "Table" {lexeme=yytext(); return TABLEOP;}
<YYINITIAL> "for" {lexeme=yytext(); return FOROP;}
<YYINITIAL> "in" {lexeme=yytext(); return INOP;}

":" {lexeme=yytext(); return ASSIGNMENT;}
"#" {lexeme=yytext(); return COMMENT;}
"[" {lexeme=yytext(); return LB;}
"]" {lexeme=yytext(); return RB;}
"{" {lexeme=yytext(); return LC;}
"}" {lexeme=yytext(); return RC;}
"(" {lexeme=yytext(); return LP;}
")" {lexeme=yytext(); return RP;}
"$" {lexeme=yytext(); return EOL;}
"<" {lexeme=yytext(); return LL;}
">" {lexeme=yytext(); return RM;}
"," {lexeme=yytext(); return SEPARATOR;}
"." {lexeme=yytext(); return CONCATENATION;}

{L}({L}|{D})* {lexeme=yytext(); return ID;}
{D} ({L}|{D})* {lexeme=yytext(); return ERROR;}