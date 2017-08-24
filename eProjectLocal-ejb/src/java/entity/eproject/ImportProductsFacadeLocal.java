/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.eproject;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NONAME
 */
@Local
public interface ImportProductsFacadeLocal {

    void create(ImportProducts importProducts);

    void edit(ImportProducts importProducts);

    void remove(ImportProducts importProducts);

    ImportProducts find(Object id);

    List<ImportProducts> findAll();

    List<ImportProducts> findRange(int[] range);

    int count();
    
}
