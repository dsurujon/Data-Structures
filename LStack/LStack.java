/*
Linked implementation of stacks
Data Structures 605.202 Module 2
*/
import java.util.Scanner;

class SNode{
	int Data;
	SNode Next;
}

public class LStack{
	private SNode Top;
	private int size;
	
	public void LStack(){		//constructor
		Top=null;
		size=0;
	}
	
	//stack methods
	public boolean Empty(){
		return(Top==null);
	}
	
	public void push(int Item){
		SNode Temp = new SNode();	//allocate space
		Temp.Data = Item;		//add the data
		Temp.Next = Top;		//attach to top of stack
		Top = Temp;				//reset top
	}
	
	public int pop(){
		int Item;
		SNode Temp = Top;
		if (Empty()) {
			System.out.println("Stack is empty, cannot pop");
			return 0;
			//handle error
		}
		else{
			Item = Top.Data;	//Get the data
			Top = Top.Next;		//Reset top
			Temp.Next = null;	//detatch node
			return Item;		
		}
	}
	
	public int peek(){
		if (Empty()){
			System.out.println("Stack is empty");
			return 0;
		}
		else{
			int Item = pop();
			push(Item);
			return Item;
		}
	}
	
	private static Scanner scanner = new Scanner( System.in );
	
	public static void main(String[] args){
		boolean quit=false;
		LStack s = new LStack();
		System.out.println("Stack demo: you now have an empty stack.");
		System.out.println("Available commands are 'Empty', 'push' and 'pop'");
		System.out.println("Type 'q' to quit.");
		while(!quit){
			String input = scanner.nextLine();
			
			if (input.equals("q")){
				quit=true;
			}
			else if (input.equals("Empty")){
				boolean isempty = s.Empty();
				System.out.println(isempty);
			}
			else if (input.equals("pop")){
				int p = s.pop();
				System.out.println(p);
				System.out.println("Your stacktop after pop:");
				System.out.println(s.peek());
			}
			else if (input.equals("push")){
				System.out.println("Push an integer:");
				String pushedvar = scanner.nextLine();
				int pvar = Integer.parseInt(pushedvar);
				s.push(pvar);
				System.out.println("Your stacktop after push:");
				System.out.println(s.peek());				
			}
			else{
				System.out.println("Command '"+input+"' not recognized");
			}
		}
		System.exit(0);	
	} // end of main
} // end class LStack
