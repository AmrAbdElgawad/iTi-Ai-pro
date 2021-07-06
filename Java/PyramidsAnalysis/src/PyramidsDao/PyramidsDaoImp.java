/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PyramidsDao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import PyramidsObjects.Pyramid;

/**
 *
 * @author amr
 */
public class PyramidsDaoImp implements PyramidDao{

    @Override
    public List<Pyramid> getPyramidsData(String path) {
        List<Pyramid> allPyramid = new ArrayList();
        try {
            Scanner sc=new Scanner(new File(path));
            //to start reading after the heading row
            if (sc.hasNextLine())
                sc.nextLine();
            boolean nullFlag;
            while(sc.hasNextLine()){
            nullFlag=false;
            String record=sc.nextLine();
            String [] splitted_record=record.split(",");
            //to detect and remove nan values 
                for (String splitted1 : splitted_record) {
                    
                    if (splitted1.isEmpty()) {
                        nullFlag=true;
                    }
                    
                }
            if (nullFlag==false){
             Pyramid pyrmd=new Pyramid(splitted_record[0],Integer.parseInt(splitted_record[3]),splitted_record[4],splitted_record[12],Double.parseDouble(splitted_record[7]));

            allPyramid.add(pyrmd);
            }
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PyramidsDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        return allPyramid;
    }
    
}
