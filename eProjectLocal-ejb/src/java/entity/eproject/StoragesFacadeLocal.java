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
public interface StoragesFacadeLocal {

    void create(Storages storages);

    void edit(Storages storages);

    void remove(Storages storages);

    Storages find(Object id);

    List<Storages> findAll();

    List<Storages> findRange(int[] range);

    int count();
    
}
