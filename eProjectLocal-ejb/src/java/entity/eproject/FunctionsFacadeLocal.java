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
public interface FunctionsFacadeLocal {

    void create(Functions functions);

    void edit(Functions functions);

    void remove(Functions functions);

    Functions find(Object id);

    List<Functions> findAll();

    List<Functions> findRange(int[] range);

    int count();
    
}
