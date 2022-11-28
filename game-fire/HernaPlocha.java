
/**
 * Write a description of class HernaPlocha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HernaPlocha {
    private Horenie horenie;
    private Zem zem;
    private Casovac casovac;
    private Manazer manazer;
    private Displej displej;
    
    public void start(){
        this.displej = new Displej(40,40,10);
        this.manazer.spravujObjekt(this);
        Platno.dajPlatno().prekresli();//+---------------------------------------------------//
    }
    
    public HernaPlocha() {
        this.horenie = new Horenie();
        this.zem = new Zem();
        this.casovac = new Casovac(this);
        this.manazer = new Manazer();
    }
    
    public void spustiHru(int pocetTikov){
        this.manazer.spravujObjekt(this.casovac);
        this.casovac.start(pocetTikov);
    }
    
    /*public void jeCas(){
        this.manazer.prestanSpravovatObjekt(this.casovac);
    }*/
}
