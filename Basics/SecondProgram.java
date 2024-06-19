//Taking input from keyboard
import java.lang.*;
import java.util.*;

class SecondProgram{
    public static void main(String[] args) {
        //Scanner class is present inside utils pakage
         Scanner s=new Scanner(System.in);
         int a,b;
         System.err.println("Please Enter Two Integer a and b: ");

         a=s.nextInt();
         b=s.nextInt();

         System.err.println(a+b);

    }
}

//class Scanner contains
// nextInt() //for integer
// nextFloat()
// nextDouble()
// next() //read one word
// nextLine() //read a line
// nextByte()
// nextShort()
// nextLong()
// nextBoolean()

// hasNextInt()//to check if the next comming data is integer or not
// hasNextFloat()