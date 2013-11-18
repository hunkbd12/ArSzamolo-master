/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arszamolo;

/**
 *
 * @author Gazdag András
 */
public class Termek {
    private String termekNev;
    private int beszerzesiAr;

    
    public Termek(String nev, int ar) {
        termekNev = nev;
        beszerzesiAr = ar;

    }
    
    public int getBeszerzesiAr() {
        return beszerzesiAr;
    }
    
    public String getTermekNev() {
        return termekNev;
    }
    
    
    
    
}
