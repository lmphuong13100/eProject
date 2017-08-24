/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.eproject;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NONAME
 */
@Stateless
public class ExportProductsFacade extends AbstractFacade<ExportProducts> implements ExportProductsFacadeLocal {

    @PersistenceContext(unitName = "eProjectLocal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExportProductsFacade() {
        super(ExportProducts.class);
    }
    
}
