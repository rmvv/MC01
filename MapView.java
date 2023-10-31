/**
 * The MapView class helps render a PositionGrid object to the terminal,
 * providing a visual representation of the grid's contents.
 * 
 */
public class MapView {
    /**
     * The grid to be rendered.
     */
    private PositionGrid CGrid;
    
    /**
     * Constructs a MapView with the specified PositionGrid.
     *
     * @param grid  the grid instantiated by PositionGrid to be rendered by this MapView.
     */
    public MapView(PositionGrid CGrid){
        this.CGrid = CGrid;
    }

    /**
     * Renders the PositionGrid to the terminal.
     * This method iterates over each position in the grid, printing the character associated
     * with that position.
     */
    public void renderMap(){
        int y, x;
        for(y = 0; y < CGrid.getHeight(); y++){
            for(x = 0; x < CGrid.getWidth(); x++){
                System.out.print(" ");
                System.out.print(CGrid.getCharacter(x, y));
            }
            System.out.println();
        }
    }
    
}
