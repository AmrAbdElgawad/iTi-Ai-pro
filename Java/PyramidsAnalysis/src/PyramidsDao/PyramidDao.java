/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PyramidsDao;

import java.util.List;
import PyramidsObjects.Pyramid;

/**
 *
 * @author amr
 */
public interface PyramidDao {
    
    List<Pyramid> getPyramidsData(String path);
}
