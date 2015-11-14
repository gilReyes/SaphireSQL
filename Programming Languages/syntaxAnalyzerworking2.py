import ply.yacc as yacc

#Getting the token
from lexicalAnalyzer import tokens

var = []
temp = []
resultQueries = []
tracker = 0


def p_expression_table(p):
    'expression : ID ASSIGNMENT LB ID RB LP IDS RP EOL'
    temp.insert(0, p[4])
    var.append(temp)
    #print('entering table')

def p_expression_ids(p):
    '''IDS : IDS SEPARATOR IDS
    | ID'''
    if(not(p[1] is None)):
        temp.append(p[1])
        #print('entering ids')
    
def p_expression_display(p):
    'expression : DISPLAY LP ID CONCATENATION QGEN RP EOL'
    #print('entering display')
    for array in range(0, len(var)):
        print('{}{}'.format('lenght array', array))
        for elem in range(1, len(var[array])):
            print('{}{}'.format('lenght var[array]', len(var[array])))
            print('SELECT ' + var[array][elem] + ' FROM ' + var[array][0])
        
    
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
