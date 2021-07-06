/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PyramidsDisplay;

import PyramidsDao.PyramidsDaoImp;
import PyramidsObjects.Pyramid;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author amr
 */
public class DisplayPyramids {
    public static void main(String[] args){
    PyramidsDaoImp pyrmd=new PyramidsDaoImp();
    List<Pyramid> pd=pyrmd.getPyramidsData("/home/amr/NetBeansProjects/PyramidsAnalysis/pyramids.csv");
    //printing output 
    System.out.println(pd);
    //writing output into txt file
    FileWriter fw;
        try {
            fw = new FileWriter("/home/amr/NetBeansProjects/PyramidsAnalysis/pyramids_data.txt",true);
            PrintWriter pw=new PrintWriter(fw);
            pw.print(pd);
            pw.close();

        } catch (IOException ex) {
            Logger.getLogger(DisplayPyramids.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
