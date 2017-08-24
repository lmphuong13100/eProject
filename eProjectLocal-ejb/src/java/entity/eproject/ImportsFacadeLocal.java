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
public interface ImportsFacadeLocal {

    void create(Imports imports);

    void edit(Imports imports);

    void remove(Imports imports);

    Imports find(Object id);

    List<Imports> findAll();

    List<Imports> findRange(int[] range);

    int count();
    
}
