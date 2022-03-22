public class Notation extends Object {

public Notation(){
}
public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException
, StackOverflowException, StackUnderflowException{

MyStack<String> myStack = new MyStack<>(15);

for(int i = 0; i < postfix.length(); i++) {

char n = postfix.charAt(i);

switch(n) {

case ' ': break;
case '0','1','2','3','4', '5', '6','7', '8', '9':
myStack.push(n + "");
break;

case '-', '+', '/','*':

if (myStack.size() < 2)
throw new InvalidNotationFormatException();

else {

String operand2 = (String) myStack.top();
myStack.pop();
String operand1 = (String) myStack.top();
myStack.pop();

String finalExp = "(" + operand1 + n + operand2 + ")";

myStack.push(finalExp);}
break;
}
}

if (myStack.size() > 1)
throw new InvalidNotationFormatException();
else {
return (String) myStack.top();}
}

public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException, QueueOverflowException , StackOverflowException, StackUnderflowException
{

MyStack<Character> theStack = new MyStack<Character>(15);
MyQueue<Character> theQueue = new MyQueue<Character>(15);

int r = 0;
int l = 0;

for(int i = 0; i < infix.length(); i++) {

char n = infix.charAt(i);

switch(n) {

case ' ': break;
case '0','1','2','3','4', '5', '6','7', '8', '9':
theQueue.enqueue(n) ;
break;

case '(':
l++;
theStack.push(n);
break;

case'-': case '+':  case'/': case'*':
while ( order(n) <= order((char) theStack.top()) && !theStack.isEmpty() )
{
char operator = (char) theStack.top();
theQueue.enqueue(operator);

}
theStack.push(n);
break;

case ')':
r++;
while((char)theStack.top() != '(' && !theStack.isEmpty())
{
char topOperator = (char) theStack.pop();
theQueue.enqueue(topOperator);
}

if ( (char)theStack.top() == '(' && theStack.size() > 1)
theStack.pop();
break;
}
}

if ( l != r)
throw new InvalidNotationFormatException ();

while(!theStack.isEmpty())
{

if ((char)theStack.top() == '(')
theStack.pop();
else {
char top_Operator = (char) theStack.pop();
theQueue.enqueue( top_Operator);
}
}

return theQueue.toString();
}

public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException
, QueueOverflowException, StackOverflowException, StackUnderflowException{


String post = convertInfixToPostfix(infixExpr);

double evaluatePost = evaluatePostfixExpression(post);

return evaluatePost;
}

static int order(char val){

switch ( val ) {

case '*', '/':
return 2;

case '+', '-':
return 1;

}
return -1;
}


public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException, StackOverflowException, StackUnderflowException{

int op2 = 0;
int op1 = 0;

MyStack<Integer> myStack = new MyStack<>(30);

for( int i=0; i < postfixExpr.length(); i++) {

char n = postfixExpr.charAt(i);

switch(n) {

case ' ': break;
case '0','1','2','3','4', '5', '6','7', '8', '9':
myStack.push(n - '0');
break;

case'-':
if (myStack.size() < 2) {
throw new InvalidNotationFormatException();
}
else {
op2 = (int) myStack.pop();
op1 = (int) myStack.pop();
myStack.push(op1 - op2);
}
break;

case '+':
if (myStack.size() < 2) {
throw new InvalidNotationFormatException();
}
else {
op2 = (int) myStack.pop();
op1 = (int) myStack.pop();
myStack.push(op1 + op2);
}
break;

case'*':
if (myStack.size() < 2) {
throw new InvalidNotationFormatException();
}
else {
op2 = (int) myStack.pop();
op1 = (int) myStack.pop();
myStack.push(op1 * op2);
}
break;

case'/':
if (myStack.size() < 2) {
throw new InvalidNotationFormatException();
}
else {
op2= (int) myStack.pop();
op1 = (int) myStack.pop();
myStack.push(op1 / op2);
}
break;

}
}

if ( myStack.size() > 1) {
throw new InvalidNotationFormatException();
}

return (double) myStack.pop();
}
}
