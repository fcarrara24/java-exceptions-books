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
                System.out.println("scrivere un numero itero valido "+e.getMessage());
            }

        } while (!flag);

        return numero;
    }

    public static String insertString(){
        Scanner scan = new Scanner(System.in);
        String outString = "";
        while (outString.length() == 0); {
            outString = scan.nextLine();
        }
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

        int numeroPagine = 2;

        String autore = "autore";

        String editore = "editore";

        return new Libro(titolo, numeroPagine, autore, editore);
    }

    public static void main(String[] args) {
        System.out.print("Numero di libri da inserire: ");
        int numeroPagine = insertInt();

        //creazione dell'array
        Libro[] libri = new Libro[numeroPagine];

        //creazione dei libri
        for (int i = 0; i < libri.length; i++) {
            libri[i] = testLibro();
        }

        System.out.println("\n\nStampo la lista dei libri ");
        //stampa dei libri inseriti
        for (Libro libro : libri){
            System.out.println(libro.toString());
        }


    }
}
