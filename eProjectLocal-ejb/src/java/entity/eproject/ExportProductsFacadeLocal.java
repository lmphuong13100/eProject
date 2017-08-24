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
public interface ExportProductsFacadeLocal {

    void create(ExportProducts exportProducts);

    void edit(ExportProducts exportProducts);

    void remove(ExportProducts exportProducts);

    ExportProducts find(Object id);

    List<ExportProducts> findAll();

    List<ExportProducts> findRange(int[] range);

    int count();
    
}
