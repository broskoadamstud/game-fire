/**
 *  
 * @author (Sami Tebbaa, Adam Broško) 
 * @version 1.0 (9.12.2022)
 */
public class Casovac {
    private int pocetTikov;
    private int maxPocetTikov;
    private boolean jeAktivny;
    private HernaPlocha hernaPlocha;
    
    public Casovac(HernaPlocha hernaPlocha) {
        this.pocetTikov = 0;
        this.maxPocetTikov = 0;
        this.jeAktivny = false;
        this.hernaPlocha = hernaPlocha;
    }
    
    public void start(int paMax){
        this.maxPocetTikov = paMax;
        this.jeAktivny = true;
    }
    
    public void tik(){
        if(this.jeAktivny){
            this.pocetTikov++;
            if(this.pocetTikov == this.maxPocetTikov){
                this.stop();
            }
        }
    }
    
    public void stop(){
        this.jeAktivny = false;
    }
}
