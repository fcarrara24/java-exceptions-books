package org;


import static org.UtilityScanner.*;

public class Main {


    public static Libro createLibro(){

        System.out.println("/***************\\" + "\n" +
                            "| nuovo libro.. |" + "\n" +
                             "\\***************/");

        // le classi insertString e insertInt sono importate da UtilityScanner e sono statiche
        System.out.print("titolo ");
        String titolo = insertString();
        System.out.print("numero pagine ");
        int numeroPagine = insertInt();
        System.out.print("autore ");
        String autore = insertString();
        System.out.print("editore ");
        String editore = insertString();

        System.out.println("/*************\\" + "\n" +
                           "| creazione.. |" + "\n" +
                           "\\*************/" + "\n" + "\n" + "\n"
        );

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
