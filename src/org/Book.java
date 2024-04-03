package org;

public class Book {
    private String titolo;
    private int numeroPagine;
    private String autore;
    private String editore;

    public Book(String titolo, int numeroPagine, String autore, String editore) throws IllegalArgumentException, NullPointerException {
        if(titolo.isEmpty() || autore.isEmpty() || editore.isEmpty()){
            throw new NullPointerException("titolo, autore ed editore non possono essere vuoti");
        } else if (numeroPagine <= 0){
            throw new IllegalArgumentException("il numero di pagine non può essere <=0 ");
        }
        this.titolo = titolo;
        this.numeroPagine = numeroPagine;
        this.autore = autore;
        this.editore = editore;
    }

    //getters and setters


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) throws IllegalArgumentException {
        if (titolo.isEmpty()) {
            throw new IllegalArgumentException("il titolo non puo essere vuoto");
        }
        this.titolo = titolo;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) throws IllegalArgumentException {
        if ( numeroPagine <= 0 ) {
            throw new IllegalArgumentException("il numero di pagine deve essere un numero intero");
        }
        this.numeroPagine = numeroPagine;
    }

    public String getAutore() {

        return autore;
    }

    public void setAutore(String autore) throws IllegalArgumentException {
        if (autore.isEmpty()){
            throw new IllegalArgumentException("l'autore non puo essere vuoto");
        }
        this.autore = autore;
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) throws IllegalArgumentException  {
        if(editore.isEmpty()){
            throw new IllegalArgumentException("l'editore non puo essere vuoto");
        }
        this.editore = editore;
    }

    // toString

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + titolo + '\'' +
                ", numeroPagine=" + numeroPagine +
                ", autore='" + autore + '\'' +
                ", editore='" + editore + '\'' +
                '}';
    }
}
