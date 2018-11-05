package com.tewinsid.demo.util;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InFixToSuffix {

    private String expression = "1+2*3+(4+5)";


    public int main() {
        Deque symbolStack = new LinkedList();
        return 1;
    }

    private String InfixToSufixx(String expression, Deque symbolStack) {
        String temp = "";
        String result = "";
        while (expression.length() > 0) {
            temp = expression.substring(0, 1);
            expression = expression.substring(1);
            if (isTempNumber(temp)) {
                result += temp;
            } else {
                if (idSymbolCanPsuh(temp, symbolStack)) {
                    symbolStack.push(temp);
                } else {
                    if (")".equals(temp)) {

                    } else {
                        result += symbolStack.pop();
                        expression = temp + expression;
                    }
//                    InfixToSufixx(expression, characterStack, symbolStack);

                }
            }

        }


        expression.substring(0, 1);

        return "";
    }

    private boolean idSymbolCanPsuh(String symbol, Deque<String> stack) {
        if (symbol == null || "".equals(symbol)) {
            throw new RuntimeException("操作符为空");
        }
        if (!"+".equals(symbol) && !"-".equals(symbol) && !"*".equals(symbol)
                && !"/".equals(symbol) && !"(".equals(symbol) && !")".equals(symbol)) {
            throw new RuntimeException("操作符异常");
        }
        if ("(".equals(symbol)) {
            return true;
        }
        if (")".equals(symbol)) {
            return false;
        }

        String top = stack.getFirst();
        int topPriority = Symbol.getPriority(top);
        int symbolPriority = Symbol.getPriority(symbol);
        if (symbolPriority - topPriority >= 0) {
            return false;
        }
        return true;
    }

    private boolean isTempNumber(String temp) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(temp);
        return matcher.matches();
    }

    @Test
    public void test() {
        System.out.println(Symbol.getPriority("*"));
    }
}

enum Symbol {
    A("+", 1),
    B("-", 1),
    C("*", 2),
    D("/", 2);

    private String symbol;
    private int priority;

    private Symbol(String symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public static int getPriority(String symbol) {
        for (Symbol temp : Symbol.values()) {
            if (temp.symbol.equals(symbol)) {
                return temp.priority;
            }
        }
        return -1;
    }
}
