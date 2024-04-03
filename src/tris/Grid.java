package tris;

public class Grid {
    private static final int HEIGHT = 3;
    private static final int  WIDTH = 3;

    private String[][] grid;

    public Grid() {
        this.grid = new String[HEIGHT][WIDTH];
    }

    public void printGrid(){
        System.out.println("  1 2 3");
        System.out.println("1 "+this.grid[0][0]+" "+this.grid[0][1]+" "+this.grid[0][2]);
        System.out.println("2 "+this.grid[1][0]+" "+this.grid[1][1]+" "+this.grid[1][2]);
        System.out.println("3 "+this.grid[2][0]+" "+this.grid[2][1]+" "+this.grid[2][2]);
    }

    public void insertTile(int x, int y) throws IndexOutOfBoundsException {
        if(!this.inBounds(x, y)){
            throw new IndexOutOfBoundsException("parametri non validi");
        }
    }

    private boolean inBounds(int x, int y){
        return (x>= 0 && x<3 && y>=0 && y<3);
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
        if(grid[3][0] != "" && grid[3][0] == grid[1][1] && grid[1][1] == grid[0][2] ) return true;

        return false;
    }
}
