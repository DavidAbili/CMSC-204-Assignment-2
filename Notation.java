

public class Notation {

	public Notation() {

	}
	
	public static String convertPostfixToInfix(String postfix)
			throws InvalidNotationFormatException {
		MyStack<String> changed = new MyStack<>();

		try {
		for (int i = 0; i < postfix.length(); i++) {
			char val = postfix.charAt(i);
			try {
				if ( val < 58 &&  val> 47)
					changed.push(String.valueOf( val));
				switch ( val) {
				case  '*', '/', '+', '-' -> {
					if (changed.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					String a = (String) changed.pop();
					changed.push("(" + changed.pop() +  val + a + ")");
				}
				}
			} catch (StackOverflowException | StackUnderflowException e) {
				e.printStackTrace();
			}
		}
		if (changed.size() != 1) {
			throw new InvalidNotationFormatException();
		}
			
			
		
	} catch(InvalidNotationFormatException e){
		throw new InvalidNotationFormatException();
	}
		return changed.toString();
	}

	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		MyStack<Double> evaluate = new MyStack<>();
		
		try {
		for (int i = 0; i < postfixExpr.length(); i++) {
			char check = postfixExpr.charAt(i);
			try {

				if (check < 58 && check > 47)
					evaluate.push((double) check - 48);
				switch (check) {
				case '*':
				case '/':
				case '+':
				case '-':

					if (evaluate.size() < 2) {
						throw new InvalidNotationFormatException();
					}
						
					else {
						double a = (double) evaluate.pop();
						double b = (double) evaluate.pop();
						switch (check) {
						case '+' -> evaluate.push(a + b);
						case '/' -> evaluate.push(b / a);
						case '-' -> evaluate.push(b - a);
						case '*' -> evaluate.push(a * b);
						}
					}

				}
			} catch (StackOverflowException | StackUnderflowException e) {
				e.printStackTrace();
			}
		}

		if (evaluate.size() != 1) {
			throw new InvalidNotationFormatException();
		}
	
		
	} catch(InvalidNotationFormatException e){
		throw new InvalidNotationFormatException();
	}
		return Double.parseDouble(evaluate.toString());
	}
	public static String convertInfixToPostfix(String infix)
			throws InvalidNotationFormatException {
		MyQueue<Character> convert = new MyQueue<>();
		MyStack<Character> symbol = new MyStack<>();

		for (int i = 0; i < infix.length(); i++) {
			char val = infix.charAt(i);
			try {
				if (val < 58 && val > 47) {
					convert.enqueue(val);
				}
					

				if (val == '(') {
					symbol.push(val);
				}
						
				switch (val) {
				case '*':
				case '/':
				case '+':
				case '-':
					if (symbol.size() != 0) {

						if ((char)symbol.top() == '/') {
							symbol.push(val);
						} else {
							symbol.push(val);
						}
					}
					else
						symbol.push(val);
				}
				if (val == ')') {
					while ((char)symbol.top() != '(') {
						convert.enqueue(symbol.pop());
						if (symbol.size() == 0)
							throw new InvalidNotationFormatException();
					}
					symbol.pop();
				}
			} catch (  StackOverflowException|QueueOverflowException | StackUnderflowException e) {
				e.printStackTrace();
			}
		}
		try {
			while (symbol.size() != 0) {
				convert.enqueue(symbol.pop());
			}
				
		} catch (QueueOverflowException | StackUnderflowException e) {
			e.printStackTrace();
		}
		return convert.toString();

	}
}