package CardGame;

import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * Name: Elizabeth Hillman
 * Date: 10/26
 * Period: 1
 * <p>
 * CardGame.DeckOfCardsTest.java
 * <p>
 * Tester program to shuffle and deal a deck of Card objects
 */

public class DeckOfCardsTest {

    public static void main(String[] args) {
        int counter = 0;
        int totalValue = 0;
        int dealerValue = 0;
        String rep = null;
        String dealerRep = null;
        Scanner scan = new Scanner(System.in);
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // put Card objects in random order

        // -----------------------------------------------------------
        //  print all 52 Cards in the order in which they are dealt
        // -----------------------------------------------------------
//        for (int i = 0; i < 13; i++)
//        {
//            // printf method is used for formatting output
//            // print string (%) in a space of 20 characters (20s)
//            // the - in the (-20s) makes the String left align
//            // printf can be used with floats, ints and other types as well
//            // cheat sheet @ https://thejavacheatsheet.wordpress.com/2015/04/11/printf/
//            // Guide #2 https://www.cs.colostate.edu/~cs160/.Summer16/resources/Java_printf_method_quick_reference.pdf
//            System.out.printf("%-20s%-20s%-20s%-20s\n",
//                myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
//                myDeckOfCards.dealCard(), myDeckOfCards.dealCard());
//
//        }

        System.out.println("Dealer's hand: ");
        Card d = myDeckOfCards.dealCard();
        if (d.getFace().equals("Ace")) {
            if (dealerValue < 11)
                dealerValue += 11;
            else if (dealerValue > 10)
                dealerValue += 1;
        }
        System.out.println(d.toString());
        System.out.println();

        System.out.println("Player's hand: ");
        Card x = myDeckOfCards.dealCard();
        counter++;
        if (x.getFace().equals("Ace")) {
            if (totalValue < 11)
                totalValue += 11;
            else if (totalValue > 10)
                totalValue += 1;
        }
        Card y = myDeckOfCards.dealCard();
        counter++;
        if (y.getFace().equals("Ace") && (totalValue + 11) > 21) {
            totalValue += 1;
        }
        else if(y.getFace().equals("Ace") && (totalValue + 11) < 22){
                totalValue += 11;
            }


        System.out.println(x.toString());
        totalValue += x.getValue();

        System.out.println(y.toString());
        totalValue += y.getValue();
        System.out.println("Total value: " + totalValue);
        if (totalValue == 21) {
            rep = "blackjack";
            System.out.println("Player wins!");
            System.exit(0);

        }

        String s = (x.toString() + "\n" + y.toString());


            System.out.println();
            System.out.println("hit or stay?");
            String r = scan.nextLine();
            System.out.println();

        while ((r.equalsIgnoreCase("hit") || r.equalsIgnoreCase("h")) && totalValue < 21) {

            System.out.println("Dealer's hand: ");
            System.out.println(d.toString());
            System.out.println();

            System.out.println("Player's hand: ");
            Card t = myDeckOfCards.dealCard();
            counter++;
            s += "\n" + t.toString();

            if (t.getFace().equals("Ace") && (totalValue + 11) > 21) {
                totalValue += 1;
            } else if (t.getFace().equals("Ace") && (totalValue + 11) < 22) {
                totalValue += 11;
            }

            if (counter < 4) {
                if ((x.getFace().equals("Ace") || y.getFace().equals("Ace")) && (totalValue + t.getValue()) > 21) {
                    totalValue -= 10;
                }
            }
            //if (counter == 4) {
            //    if ((x.getFace().equals("Ace") || y.getFace().equals("Ace")) && (totalValue + t.getValue()) > 21) {
            //        totalValue -= 10;
            //    }
            //}



            System.out.println(s);
            totalValue += t.getValue();


            System.out.println("Total value: " + totalValue);

            if (totalValue == 21) {
                System.out.println();
                System.out.println("Player wins!");
                rep = "blackjack";
                break;
            }
            if (totalValue > 21) {
                System.out.println();
                rep = "bust";
                System.out.println("Player busts!");
                System.out.println("Dealer wins!");
                break;
            }

            System.out.println();
            System.out.println("hit or stay?");
            r = scan.nextLine();
            System.out.println();
        }
        if (r.equalsIgnoreCase("stay") || r.equalsIgnoreCase("s")) {
            System.out.println("Dealer's hand: ");
            System.out.println(d.toString());
            Card d1 = myDeckOfCards.dealCard();

            if (d1.getFace().equals("Ace") && (dealerValue + 11) > 21) {
                    dealerValue += 1;
            }
            else if (d1.getFace().equals("Ace") && (dealerValue + 11) < 22){
                dealerValue += 11;
            }

            System.out.println(d1.toString());
            dealerValue += d.getValue() + d1.getValue();
            System.out.println("Dealer's total: " + dealerValue);
            System.out.println();
            System.out.println("Player's hand: ");
            System.out.println(s);
            System.out.println("Total value: " + totalValue);
            System.out.println();

            String dealer = (d.toString() + "\n" + d1.toString());

            if (dealerValue < 18 && dealerValue != 17) {
                Card dealerCard = myDeckOfCards.dealCard();

                if (dealerCard.getFace().equals("Ace") && (dealerValue + 11) > 21) {
                        dealerValue += 1;
                }
                else if (dealerCard.getFace().equals("Ace") && (dealerValue + 11) < 22) {
                    dealerValue += 11;
                }

                if((d.getFace().equals("Ace") || d1.getFace().equals("Ace")) && (dealerValue + dealerCard.getValue()) > 21){
                    dealerValue -= 10;
                }

                dealer += "\n" + dealerCard.toString();
                dealerValue += dealerCard.getValue();

                System.out.println("Dealer's hand: ");
                System.out.println(dealer);
                System.out.println("Dealer's total: " + dealerValue);
                System.out.println();
                System.out.println("Player's hand: ");
                System.out.println(s);
                System.out.println("Total value: " + totalValue);
                System.out.println();
            }
            if (dealerValue < 18 && dealerValue != 17) {
                Card dealerCard2 = myDeckOfCards.dealCard();
                dealer += "\n" + dealerCard2.toString();
                dealerValue += dealerCard2.getValue();
                System.out.println("Dealer's hand: ");
                System.out.println(dealer);
                System.out.println("Dealer's total: " + dealerValue);
                System.out.println();
                System.out.println("Player's hand: ");
                System.out.println(s);
                System.out.println("Total value: " + totalValue);
                System.out.println();

            }
            if (dealerValue == 21) {
                dealerRep = "blackjack";
                System.out.println("Dealer wins!");

            }
            if (dealerValue > 21) {
                dealerRep = "bust";
                System.out.println("Dealer busts!");
                System.out.println("Player wins!");
            }
        }


        if (dealerValue > totalValue && dealerRep != "bust" && dealerRep != "blackjack") {
            System.out.println("Dealer wins!");
        }
        if (totalValue > dealerValue && rep != "bust" && rep != "blackjack" && rep != "error") {
            System.out.println("Player wins!");
        }

        System.out.println();
        if (totalValue == dealerValue) {
            System.out.println("It's a tie!");
        }
    }

}

