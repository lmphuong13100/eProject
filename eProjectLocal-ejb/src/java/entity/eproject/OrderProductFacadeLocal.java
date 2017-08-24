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
public interface OrderProductFacadeLocal {

    void create(OrderProduct orderProduct);

    void edit(OrderProduct orderProduct);

    void remove(OrderProduct orderProduct);

    OrderProduct find(Object id);

    List<OrderProduct> findAll();

    List<OrderProduct> findRange(int[] range);

    int count();
    
}
