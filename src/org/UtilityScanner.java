package org;

import java.util.Scanner;

public class UtilityScanner {

    public static int insertInt(){
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int numero = 0;
        do{
            try {
                numero = Integer.parseInt(scan.nextLine());
                if(numero > 0) flag = true;
            } catch (NumberFormatException e) {
                System.out.println("scrivere un numero intero valido ");
            }

        } while (!flag);


        return numero;
    }

    public static String insertString(){
        Scanner scan = new Scanner(System.in);
        String outString = null;
        do {
            outString = scan.nextLine();
            if(outString.length() == 0) System.out.println("Il campo non puo essere nullo ");
        } while (outString.length() == 0);

        return outString;
    }
}
