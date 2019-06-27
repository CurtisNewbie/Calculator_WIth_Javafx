package model;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class CalculationAction {

    private final static String ADD_OPER = "+";
    private final static String SUB_OPER = "-";
    private final static String MUL_OPER = "*";
    private final static String DIV_OPER = "/";

    // This should be recursive.
    public static String parseQuery(String query) {
	StringTokenizer strToken = new StringTokenizer(query, " ");
	int numOfToken = strToken.countTokens();
	List<String> list = new LinkedList<>();
	for (int x = 0; x < numOfToken; x++) {
	    list.add(strToken.nextToken());
	}

	String str;
	boolean loopFinished = false; // when it identifies an operator, check the whole list one more time.
	while (!loopFinished) {
	    loopFinished = true;
	    // first loop detecting multiplication and division
	    for (int x = 0; x < list.size(); x++) {
		str = list.get(x);
		if (isOperator(str)) {
		    String thisResult;
		    if (str.equals(MUL_OPER)) {
			thisResult = multiply(Double.parseDouble(list.get(x - 1)), Double.parseDouble(list.get(x + 1)));
			list.set(x, thisResult);
			list.remove(x - 1);
			list.remove(x);
			loopFinished = false;
		    } else if (str.equals(DIV_OPER)) {
			thisResult = divide(Double.parseDouble(list.get(x - 1)), Double.parseDouble(list.get(x + 1)));
			list.set(x, thisResult);
			list.remove(x - 1);
			list.remove(x);
			loopFinished = false;
		    }
		}
	    }
	}

	loopFinished = false;
	while (!loopFinished) {
	    loopFinished = true;
	    // second loop detecting addition and subtraction
	    for (int x = 0; x < list.size(); x++) {
		str = list.get(x);

		if (isOperator(str)) {
		    String thisResult;
		    if (str.equals(ADD_OPER)) {
			thisResult = add(Double.parseDouble(list.get(x - 1)), Double.parseDouble(list.get(x + 1)));
			list.set(x, thisResult);
			list.remove(x - 1);
			list.remove(x);
			loopFinished = false;
		    } else if (str.equals(SUB_OPER)) {
			thisResult = subtract(Double.parseDouble(list.get(x - 1)), Double.parseDouble(list.get(x + 1)));
			list.set(x, thisResult);
			list.remove(x - 1);
			list.remove(x);
			loopFinished = false;
		    }
		}
	    }
	}
	return list.get(0);
    }

    // add up num1 and num2
    public static String add(double num1, double num2) {
	return "" + (num1 + num2);
    }

    // Subtract num1 from num2
    public static String subtract(double num1, double num2) {
	return "" + (num1 - num2);
    }

    // Multiply num1 by num2
    public static String multiply(double num1, double num2) {
	return "" + (num1 * num2);
    }

    // Divide num1 by num2
    public static String divide(double num1, double num2) {
	return "" + (num1 / num2);
    }

    // is operator
    private static boolean isOperator(String str) {
	if (str.matches("\\d{1,}")) {
	    return false;
	} else {
	    return true;
	}
    }

}
