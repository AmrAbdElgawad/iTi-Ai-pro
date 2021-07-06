/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ischarachter;
import java.lang.Character;
/**
 *
 * @author amr
 */
public class IsCharachter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Letter ischr=(String s)->
        {
    char[] x = s.toCharArray();
   int counter=0;
    for (int i=0;i<x.length;i++){
    if(Character.isLetter(x[i]))
    counter++;
      else
    counter--; 
    }
    if (counter<x.length)
        return false;
    else 
        return true;
    };
        
        String sr1="amr12Eid";
        String sr2="AmrEid";
        System.out.println(ischr.isChar(sr1));
        System.out.println(ischr.isChar(sr2));

}
}
    
