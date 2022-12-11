/**
 *  
 * @author (Sami Tebbaa, Adam Broško) 
 * @version 1.0 (9.12.2022)
 */
public class Displej {
    private PolickoDispleja[][] poleDisplejPolicok;
    private int sirkaPolicka;
    
    public Displej(int vyska, int sirka, int sirkaPolicka) {
        this.sirkaPolicka = sirkaPolicka;
        this.poleDisplejPolicok = new PolickoDispleja[vyska][sirka];
        for(int i = 0; i < this.poleDisplejPolicok.length; i++){
            for(int j = 0; j < this.poleDisplejPolicok[i].length; j++){
                this.poleDisplejPolicok[i][j] = new PolickoDispleja(j * this.sirkaPolicka, i * this.sirkaPolicka, this.sirkaPolicka);    
            }
        }
    }
    
    public Suradnica transformujSuradnice(int x, int y){
        if((x < 0) || (y < 0) || (x > this.sirkaPolicka * this.poleDisplejPolicok.length) || (y > this.sirkaPolicka * this.poleDisplejPolicok.length)){
            return null;
        }else{
            return new Suradnica(y / this.sirkaPolicka, x / this.sirkaPolicka);
        }
    }
    
    public void zobrazZasah(boolean zasahLode, int x, int y){
        
    }
            
}
