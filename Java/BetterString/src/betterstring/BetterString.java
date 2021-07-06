/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betterstring;

/**
 *
 * @author amr
 */
public class BetterString {

    /**
     * @param args the command line arguments
     */
    
    
    public static String betterString(String string1,String string2,IsBetter better)
            {
                boolean res=better.isBetter(string1, string2);
              if (res==true)  {
              return string1;
              }
              else
                  return string2;
    }
    public static void main(String[] args) {
       
        String Sr="Amr";
        String Sr2="Abd ElGawad";
       String SR3= betterString(Sr,Sr2,(S,S2)-> S.length()>S2.length());
        System.out.println(SR3);
     

        
    }
    
}
