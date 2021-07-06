/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PyramidsObjects;

/**
 *
 * @author amr
 */
public class Pyramid {

    String pharoah,ModernName,site,type;
      double height;
    int dynasty;
    
    
        public Pyramid(String pharoah,  int dynasty,
                String site, String type,double height) {
    
    this.pharoah=pharoah;
    this.site=site;
    this.type=type;
    this.height=height;
    this.dynasty=dynasty;
    }
     

    @Override
    public String toString() {
        return "Pyramid{" + "pharoah=" + pharoah +  ", site=" + site + ", type=" + type + ", height=" + height + ", dynasty=" + dynasty +'}'+"\n";
    }



    
}
