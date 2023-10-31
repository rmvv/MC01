/**
 * The Area class represents a grid-based area with a player that can move within it.
 * <p>
 * The player's initial position every time a grid is initialized is at (0,0), and the player itself is 
 * represented by the static character 'P' on the grid.
 * <p>
 * It provides methods that allow the player to move in four directions (up, down, left, and right)
 * within the grid. Additionally, each move is checked if the new position is within the bounds 
 * of the grid. The grid is updated accordingly upon checking if its valid, otherwise, an error
 * message is displayed and prompts the user for a valid input.
 * </p>
 */
public class Area {
    /**
     * The grid representing the Area chosen by the user.
     */
    private PositionGrid CGrid;

    /**
     * The position of the player.
     */
    private int playerX, playerY;

    /**
     * The character representing the position of the player on the grid.
     */
    private static final char PLAYER_ICON = 'P';

    /**
     * Constructs an Area object given the width and height.
     * Places the character at the starting position (0,0) on 
     * the grid after initializing.
     * 
     * @param width  the width of the grid
     * @param height the height of the grid
     */
    public Area(int width, int height){
        CGrid = new PositionGrid(width, height);
        CGrid.setCharacter(playerX, playerY, PLAYER_ICON);

    }

    /**
     * Moves the player one space up.
     * If the movement is valid, it updates the player's position.
     * Otherwise, it displays an error message.
     */
    public void moveUp(){
        if(playerY - 1 >= 0){
            CGrid.setCharacter(playerX, playerY, '*');  
            playerY--;
            CGrid.setCharacter(playerX, playerY, PLAYER_ICON);
        } 
        
        else {
            System.out.println("Can't move up!");
        }
    }

    /**
     * Moves the player one space down.
     * If the movement is valid, it updates the player's position.
     * Otherwise, it displays an error message.
     */
    public void moveDown(){
        if(playerY + 1 < CGrid.getHeight()){
            CGrid.setCharacter(playerX, playerY, '*');
            playerY++;
            CGrid.setCharacter(playerX, playerY, PLAYER_ICON);
        } 
        
        else {
            System.out.println("Can't move down");
        }
    }
    
    /**
     * Moves the player one space to the right.
     * If the movement is valid, it updates the player's position.
     * Otherwise, it displays an error message.
     */
    public void moveRight(){
        if(playerX + 1 < CGrid.getWidth()){
            CGrid.setCharacter(playerX, playerY, '*');
            playerX++;
            CGrid.setCharacter(playerX, playerY, PLAYER_ICON);
        } 
        
        else {
            System.out.println("Can't move right");
        }
    }
    
    /**
     * Moves the player one space to the left.
     * If the movement is valid, it updates the player's position.
     * Otherwise, it displays an error message.
     */
    public void moveLeft(){
        if(playerX - 1 >= 0){
            CGrid.setCharacter(playerX, playerY, '*');  
            playerX--;
            CGrid.setCharacter(playerX, playerY, PLAYER_ICON);  
        } 
        
        else {
            System.out.println("Can't move left");
        }
    }

    /**
     * Renders the grid with MapView to show the current state of the area.
     */
    public void displayArea() {
        MapView CMapView = new MapView(CGrid);
        CMapView.renderMap();
    }
}
