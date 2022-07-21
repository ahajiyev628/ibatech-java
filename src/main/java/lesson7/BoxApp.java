package lesson7;

import java.util.Scanner;

/**
 * 1 -- create 2 boxes
 * 2 -- check, could you put first box into second
 * 3 -- if yes, write "yes" on console
 * additional:
 *  create Box class
 *
 * INPUT:
 *      sBox: 5 1 3
 *      fBox: 10 1 1
 * OUTPUT:
 *      NO
 */

public class BoxApp {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        String boxParamsOne = in.nextLine();
        String boxParamsTwo = in.nextLine();

        String[] boxParamsOneArr = boxParamsOne.split(" ");
        String[] boxParamsTwoArr = boxParamsTwo.split(" ");

        Box boxOne = new Box(Integer.parseInt(boxParamsOneArr[0]), Integer.parseInt(boxParamsOneArr[1]), Integer.parseInt(boxParamsOneArr[2]));
        Box boxTwo = new Box(Integer.parseInt(boxParamsTwoArr[0]), Integer.parseInt(boxParamsTwoArr[1]), Integer.parseInt(boxParamsTwoArr[2]));

        if(boxOne.compare(boxTwo)){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }


}
