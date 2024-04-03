package tris;

public class Grid {
    private static final int HEIGHT = 3;
    private static final int  WIDTH = 3;

    private String[][] grid;

    public Grid() {
        this.grid = new String[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                this.grid[i][j] = "";
            }
        }
    }

    private String fillGrid(int x,int y){
        return (this.grid[x][y] == "" ? " " : this.grid[x][y]);
    }

    public void printGrid(){


        System.out.println("  1 2 3");
        System.out.println("1 "+this.fillGrid(0,0)+" "+this.fillGrid(0,1)+" "+this.fillGrid(0,2));
        System.out.println("2 "+this.fillGrid(1,0)+" "+this.fillGrid(1,1)+" "+this.fillGrid(1,2));
        System.out.println("3 "+this.fillGrid(2,0)+" "+this.fillGrid(2,1)+" "+this.fillGrid(2,2));
    }

    public void insertTile(int x, int y, String player) throws IndexOutOfBoundsException, IllegalArgumentException {
        if(!this.inBounds(x, y)){
            throw new IndexOutOfBoundsException("parametri non validi");
        } else if (player != "A" && player != "B"){
            throw new IllegalArgumentException("chiamare il giocatore in modo corretto ");
        } else if (this.grid[x][y] != ""){
            throw new IllegalArgumentException("chiamare il giocatore in modo corretto ");
        }
        this.grid[x][y] = player;
    }

    private boolean inBounds(int x, int y){
        return (x>= 0 && x<3 && y>=0 && y<3);
    }
    public void testFull(){
        this.grid = new String[][]{
                {"A", "B", "B"},
                {"B", "C", "A"},
                {"B", "A", ""}
        };
    }

    public boolean checkwin(String player){
        int counter = 0;

        // vertical
        for (int j = 0; j < WIDTH; j++) {
            counter = 0;
            for (int i = 0; i < HEIGHT; i++) {
                if(player == grid[j][i]) counter ++;
            }

            if(counter == 3) return true;
        }

        //horiziontal
        for (int j = 0; j < WIDTH; j++) {
            counter = 0;
            for (int i = 0; i < HEIGHT; i++) {
                if(player == grid[i][j]) counter ++;
            }
            if(counter == 3) return true;
        }

        //two diagonal
        if(grid[0][0] != "" && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] ) return true;
        if(grid[2][0] != "" && grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] ) return true;

        return false;
    }

    public boolean allFull(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if(grid[i][j] == "") return false;
            }
        }

        return true;

    }
}
