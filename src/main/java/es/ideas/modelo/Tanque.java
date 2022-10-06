package es.ideas.modelo;

/**
 *
 * @author Lazaro
 */
public class Tanque {
    int temperatura;
    
    public void subirTmp(int i){
    temperatura = temperatura + i;
    }
   
    public void bajarTmp(int i){
    temperatura = temperatura - i;
    }
    
    public int infoTmp(){
        return temperatura;
    }

    public Tanque() {
        this.temperatura = 50;
    }
    
}
