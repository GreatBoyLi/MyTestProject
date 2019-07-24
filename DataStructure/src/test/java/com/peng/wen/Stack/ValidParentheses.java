package com.peng.wen.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character,Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            if (c == ')' || c == ']' || c == '}'){
                if (stack.empty()){
                    return false;
                }
                char a = stack.pop();
                if (a != map.get(c)){
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();

        System.out.println(v.isValid("(9999)"));
    }
}
