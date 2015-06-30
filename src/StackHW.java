/**
 * 2) ќпределить класс Stack. ќбъ€вить объект класса.
 * ¬вести последовательность символов и вывести ее в обратном пор€дке.
 * Created by Ёдуард on 09.06.15.
 */
import java.util.Stack;
import java.util.EmptyStackException;
public class StackHW {
public static void main(String[]args){
  Stack stack = new Stack();
  Stack stack1 = new Stack();
    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");
    stack.push("E");
    stack.push("F");
    stack.push("G");
    while (!stack.empty()){
    System.out.println(stack.peek());
    stack1.push(stack.pop());
  }
    while (!stack1.empty()){
    System.out.println(stack1.pop());
      }
}
}
