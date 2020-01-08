package LeetcodePrograms;

import java.util.Stack;


public class BackendStringCompare {
    private String getString(String str) {
        int n=str.length(), count=0;
        String result="";
        for(int i=n-1; i>=0; i--) {
            char ch=str.charAt(i);
            if(ch=='#')
                count++;
            else {
                if(count>0)
                    count--;
                else {
                    result+=ch;
                }
            }
        }
        return result;
    }

    public boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }



// second method using stack
    public boolean backspaceCompare2(String S, String T)
    {
        String newS = resolve(S);
        String newT = resolve(T);

        return newS.equals(newT);
    }

    public String resolve(String str)
    {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(i < str.length())
        {
            if(str.charAt(i) == '#')
            {
                if(!stack.isEmpty())stack.pop();
            }
            else
            {
                stack.push(str.charAt(i));
            }
            i++;
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String []args){
        String S = "ab#c", T = "ad#c";
        BackendStringCompare b = new BackendStringCompare();
        System.out.println(b.backspaceCompare(S,T));
    }
}
