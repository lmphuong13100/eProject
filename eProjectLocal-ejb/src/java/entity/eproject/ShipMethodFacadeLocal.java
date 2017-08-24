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
public interface ShipMethodFacadeLocal {

    void create(ShipMethod shipMethod);

    void edit(ShipMethod shipMethod);

    void remove(ShipMethod shipMethod);

    ShipMethod find(Object id);

    List<ShipMethod> findAll();

    List<ShipMethod> findRange(int[] range);

    int count();
    
}
