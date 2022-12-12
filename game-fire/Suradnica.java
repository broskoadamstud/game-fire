/**
 *  
 * @author (Sami Tebbaa, Adam Broško) 
 * @version 1.0 (9.12.2022)
 */
public class Suradnica {
    private int x;
    private int y;
    
    /**
     * @param  x nastavenie suradnice x
     * @param  y nastavenie suradnice y
     */
    public Suradnica(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * vrat suradnicu x
     */
    public int getX(){
        return this.x;
    }
    
    /**
     * vrat suradnicu y
     */
    public int getY(){
        return this.y;
    }
}
