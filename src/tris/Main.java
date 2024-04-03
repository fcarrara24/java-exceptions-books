package tris;

public class Main {
    static Grid g = null;

    private static void turn(String p){
        int x;
        int y;
        g.printGrid();
        boolean flag = false;

        System.out.println("\n\nturno giocatore "+p);
        do {
            try {
                System.out.print("inserire le coordinate orizzontale: ");
                x = UtilityScanner.insertInt();
                System.out.print("inserire le coordinate verticale: ");
                y = UtilityScanner.insertInt();
                g.insertTile(x-1, y-1, p);
                flag = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("le coordinate devono essere compreso tra 1 e 3");
            } catch (IllegalArgumentException e) {
                System.out.println("le coordinate devono essere un intero e non possono occupare un altro spazio ");
            }
        } while (!flag);


    }

    public static void main(String[] args) {
        g = new Grid();
        final String A = "A";
        final String B = "B";
        boolean win = false;
        boolean draw = false;
        int turno = 1;
        //g.testFull();
        while(!win && !draw){

            draw = g.allFull();

            if(!draw){
                if(turno % 2 == 1) {
                    turn("A");
                    win = g.checkwin("A");
                } else {
                    turn("B");
                    win = g.checkwin("B");
                }

            }
            turno ++;
        }

        g.printGrid();
        // stampo la vittoria
        if(draw) System.out.println("pareggio ");
        else if (win) {
            System.out.println("ha vinto il giocatore " +( turno % 2 == 0 ? "A":"B"));
        }
    }
}
