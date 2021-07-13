import java.util.*;
import java.util.stream.*;
  
class Demo
{
  static String infix = "23*54*+9-";
  public static void main(String args[])
  {
      Stack<Integer> list = new Stack<Integer>();
      for (int i = 0; i < infix.length(); i++) {
        if (isOperator(infix.charAt(i),list)) {
          
          
        } else {
          Character A = infix.charAt(i);
          int x = Character.getNumericValue(A);
          list.push(x);
        }
      }
      System.out.println(list.peek());
  }
  static boolean isOperator(Character key, Stack<Integer> list){
    int firstPop, secondPop;
    switch (key) {
      case '*':{
        firstPop = list.pop();
        secondPop = list.pop();
        list.push(firstPop*secondPop);
        return true;
      }
      case '+':{
        firstPop = list.pop();
        secondPop = list.pop();
        list.push(firstPop+secondPop);
        return true;
      }
      case '-':
        {
          firstPop = list.pop();
          secondPop = list.pop();
          list.push(secondPop - firstPop);
          return true;
        }
      case '/':{
        firstPop = list.pop();
        secondPop = list.pop();
        list.push(firstPop/secondPop);
        return true;
      }
    
      default:
        break;
    }
    return false;
  }
}
