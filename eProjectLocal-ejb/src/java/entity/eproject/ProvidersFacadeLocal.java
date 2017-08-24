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
public interface ProvidersFacadeLocal {

    void create(Providers providers);

    void edit(Providers providers);

    void remove(Providers providers);

    Providers find(Object id);

    List<Providers> findAll();

    List<Providers> findRange(int[] range);

    int count();
    
}
