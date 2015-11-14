import ply.yacc as yacc

#Getting the token
from lexicalAnalyzer import tokens

var = [[]]
resultQueries = []
tracker = 0

def p_expression_table(p):
    'expression : ID ASSIGNMENT LB ID RB LP IDS RP EOL'
    var[tracker].insert( 0, p[4])
    #print('entering table')

def p_expression_ids(p):
    '''IDS : IDS SEPARATOR IDS
    | ID'''
    if(not(p[1] is None)):
        var[tracker].append(p[1])
        #print('entering ids')
    
def p_expression_display(p):
    'expression : DISPLAY LP ID CONCATENATION QGEN RP EOL'
    #print('entering display')

    for  elem in range(1, len(var[0])):
            resultQueries.append('SELECT ' + var[0][elem] + ' FROM ' + var[0][0])
        
    
#Error rule
def p_error(p):
    print("Syntax error in input!")

# Build the parser
parser = yacc.yacc()

while True:
   try:
       s = input('syntax > ')
   except EOFError:
       break
   if not s: continue
   result = parser.parse(s)
   print(resultQueries)
