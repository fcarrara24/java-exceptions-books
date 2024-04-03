package org;

import java.util.Scanner;

public class Main {
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

//        scan.close();
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

    public static Libro createLibro(){
        System.out.print("titolo ");
        String titolo = insertString();
        System.out.print("numero pagine ");
        int numeroPagine = insertInt();
        System.out.print("autore ");
        String autore = insertString();
        System.out.print("editore ");
        String editore = insertString();

        return new Libro(titolo, numeroPagine, autore, editore);
    }

    public static  Libro testLibro(){

        String titolo = "titolo ";

        int numeroPagine = 1;

        String autore = "autore";

        String editore = "editore";

        return new Libro(titolo, numeroPagine, autore, editore);
    }

    public static void main(String[] args) {
        //inser
        System.out.print("Numero di libri da inserire: ");
        int numeroPagine = insertInt();

        //creazione dell'array
        Libro[] libri = new Libro[numeroPagine];

        //creazione dei libri
        for (int i = 0; i < libri.length; i++) {
            libri[i] = createLibro();
        }

        System.out.println("\n\nStampo la lista dei libri ");
        //stampa dei libri inseriti
        for (Libro libro : libri){
            System.out.println(libro.toString());
        }


    }
}
