package org;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.UtilityScanner.*;

public class Main {


    public static Book createLibro(){

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

        return new Book(titolo, numeroPagine, autore, editore);
    }

    public static Book testLibro(){

        String titolo = "titolo ";

        int numeroPagine = 1;

        String autore = "autore";

        String editore = "editore";

        return new Book(titolo, numeroPagine, autore, editore);
    }

    /**
     * stampa del file di inserimento
     */
    public static void printBooksFromFile(){
        try(Scanner fileReader = new Scanner(new File("./res/file.txt"))){
            while (fileReader.hasNextLine()){
                String linea = fileReader.nextLine();
                String[] arrayLine = linea.split(",");

                System.out.println("titolo: "+arrayLine[0]+", numero pagine: "+arrayLine[1]+", autore: "+arrayLine[2]+", editore: "+arrayLine[3]);
            }

        } catch ( Exception e){
            System.out.println("file not found");
        }
    }

    /**
     * uso controllato del filewriter
     * @param libri
     */
    public static void  insertBooksInFile(Book[] libri){
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("./res/file.txt");
            // inserisco tutti i dati del libro

            for (Book libro: libri) {
                fileWriter.write(libro.toDocument()+"\n");
            }

        } catch (IOException e) {
            System.out.println("non è possibile aprire il file");
        } finally {
            if(fileWriter != null){
                //chiudo il filewriter, lo metto in un blocco di eccezioni nel caso in cui il file non si riesca a chiudere
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }

    public static void main(String[] args) {
        //inser
        System.out.print("Numero di libri da inserire: ");
        int numeroPagine = insertInt();

        //creazione dell'array
        Book[] libri = new Book[numeroPagine];

        //creazione dei libri
        for (int i = 0; i < libri.length; i++) {
            libri[i] = createLibro();
        }

        insertBooksInFile(libri);

        System.out.println("salvataggio dati nel file esterno ");
        printBooksFromFile();

        System.out.println("libri visti con toString ");
        //stampa dei libri inseriti
        for (Book libro : libri){
            System.out.println(libro.toString());
        }


    }
}
