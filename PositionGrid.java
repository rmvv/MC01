/**
 * The PositionGrid class represents a grid with a specified width and height, in which it 
 * can hold and manipulate characters at specified positions within the grid.
 * <p>
 * Upon construction, each position in the grid is set with a default character '*'. Each
 * position can be then individually modified to a different character set by the player. 
 * <p>
 * The class also provides methods to retrieve information such as character position 
 * and the width and height of the grid. It also ensures that the positions inputted by 
 * the user are within the bounds of the grid.
 * </p>
 * 
 */
public class PositionGrid {
    /**
     * The grid to be generated.
     */
    private char [][] grid;

    /**
     * Constructs a new PositionGrid object using the specified width and height.
     * 
     * @param width   the width of the grid
     * @param height  the height of the grid
     */
    public PositionGrid(int width, int height){
        grid = new char[height][width];
        int y, x;
        for(y = 0; y < height; y++){
            for(x = 0; x < width; x++){
                grid[y][x] = '*';
            }
        }
    }

    /**
     * Sets the character at the specified position in the grid.
     * It displays an error message when the user inputs an 
     * invalid number.
     * 
     * @param x   the x-coordinate of the character
     * @param y   the y-coordinate of the character
     * @param ch  the character to set
     */
    public void setCharacter(int x, int y, char ch){
        if(isValidPosition(x, y)){
            grid[y][x] = ch;
        } 
        
        else {
            System.out.println("Invalid Position");
        }
    }

    /**
     * Gets the character at the specified position in the grid.
     * It displays an error message when the user inputs an 
     * invalid number.
     * 
     * @param x  the x-coordinate of the character
     * @param y  the y-coordinate of the character
     * @return   the character at the specified position
     */
    public char getCharacter(int x, int y){
        if(isValidPosition(x, y)){
            return grid[y][x];
        } 
        
        else {
            System.out.println("Invalid Position");
            return '\0';
        }
    }

    /**
     * Gets the width of the grid.
     * 
     * @return  the width of the grid
     */
    public int getWidth(){
        return grid[0].length;
    }

    /**
     * Gets the height of the grid.
     * 
     * @return the height of the grid.
     */
    public int getHeight(){
        return grid.length;
    }

    /**
     * Checks if the specified position is valid or not.
     * 
     * @param x  the x-coordinate of the character
     * @param y  the y-coordinate of the character
     * @return true if the position is valid, otherwise false
     */
    private boolean isValidPosition(int x, int y){
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }
    
}
