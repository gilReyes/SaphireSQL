import ply.lex as lex

tokens = ['ID', 'SEPARATOR','CONCATENATION','ASSIGNMENT','RB', 'LB','RP','LP','EOL','QGEN','DISPLAY','COMMENT']

t_ignore = ' \t' # allow whitespace
t_ID = r'\w+'
t_SEPARATOR = r'\,'
t_CONCATENATION = r'\.'
t_ASSIGNMENT = r'\:'
t_RB = r'\]'
t_LB = r'\['
t_RP = r'\)'
t_LP = r'\('
t_EOL = r'\$'
t_ignore_COMMENT = r'\#.*'
t_DISPLAY = r'display'
t_QGEN = r'QGen'

# Error handling rule
def t_error(t):
    print("Illegal character '%s'" % t.value[0])
    t.lexer.skip(1)

#Build the lexer
lex.lex()

#Lexer input
lex.input('table: [students](id,sname,sdept,age)$ #hi$')
#lex.input('display(table.QGen)$')

#Tokenize
while True:
    tok = lex.token()
    if not tok: break #EOF
    print(tok.type, tok.value)
