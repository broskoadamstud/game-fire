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
    
    /*public void zobrazZasahLode() {
        this.kruh.zmenFarbu("red");
        this.kruh.zobraz();
    }*/
    
    /*public void zobrazZasahVody() {
        this.stvorec.zmenFarbu("green");
        this.stvorec.zobraz();
    }*/
    
    /*public void reset() {
        this.kruh.skry();
        this.stvorec.zmenFarbu("blue");
    }*/
}