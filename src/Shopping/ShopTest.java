package Shopping;
import java.util.Scanner;

public class ShopTest {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        ShoppingCart3 myCart = new ShoppingCart3();

        // create some variables to store the user response for grocery list
        String n;
        double p;
        int q;

        //int count = 0;

        //prompt the user if they want to go shopping. the program should have a loop that
        //continues as long as the user wants to shop. each time through the loop reads in the name, price,
        // and quantity of the item the user  wants to add to the cart. After adding an item to the cart, the cart
        //
        System.out.println("Would you like to go shopping? (yes or no)");
        String response = scan.nextLine();
        if(!response.equalsIgnoreCase("no")){
            while(true){
                System.out.println("What would you like to buy?");
                n = scan.nextLine();
                System.out.println("How much does it cost?");
                p = scan.nextDouble();
                System.out.println("How many do you want?");
                q = scan.nextInt();


                //This eats the "\n" that is create after entering in the quantity when you press enter
                scan.nextLine();

                myCart.addToCart(n, p, q);
                System.out.println("Would you like to buy anything else? (yes or no)");
                response = scan.nextLine();
                if(response.equalsIgnoreCase("no")){
                    break;
                }
                  //else{
                  //     count++;
                  //}


            }
        }

        System.out.println(myCart.toString());

    }
}
