/**
 *  
 * @author (Sami Tebbaa, Adam Broško) 
 * @version 1.0 (9.12.2022)
 */
public class PolickoDispleja {
    private Stvorec stvorec;
    
    public PolickoDispleja(int x, int y, int sirka) {
        this.stvorec = new Stvorec();
        this.stvorec.zmenStranu(sirka - 1);
        this.stvorec.posunVodorovne(-60 + x);
        this.stvorec.posunZvisle(-50 + y);
        this.stvorec.zmenFarbu("green");
        this.stvorec.zobraz();
    }
        
}