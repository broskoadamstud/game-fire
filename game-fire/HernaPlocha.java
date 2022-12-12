
/**
 *  
 * @author (Sami Tebbaa, Adam Broško) 
 * @version 1.0 (9.12.2022)
 */
public class HernaPlocha {
    private Horenie horenie;
    private Zem zem;
    private Casovac casovac;
    private Manazer manazer;
    private Displej displej;
    
    /**
     * Metoda start() spusti hru a nastavi stvorec s stranou dlhou 10 a generovanie 40 stvorcou do riadku/stlpca
     */
    public void start(){
        this.displej = new Displej(40,40,10);
        this.manazer.spravujObjekt(this);
        Platno.dajPlatno().prekresli();
    }
    
    /**
     * Inicializacia Horenia,Zeme,Casocava,Manazera
     */
    public HernaPlocha() {
        this.horenie = new Horenie();
        this.zem = new Zem();
        this.casovac = new Casovac(this);
        this.manazer = new Manazer();
    }
    
    /**
     * Spustenie hry
     */
    public void spustiHru(int pocetTikov){
        this.manazer.spravujObjekt(this.casovac);
        this.casovac.start(pocetTikov);
    }
        
}
