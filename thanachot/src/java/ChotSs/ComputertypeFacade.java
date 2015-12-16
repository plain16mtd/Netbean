/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChotSs;

import Chot.Computertype;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Windows 8.1
 */
@Stateless
public class ComputertypeFacade extends AbstractFacade<Computertype> {

    @PersistenceContext(unitName = "thanachotPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComputertypeFacade() {
        super(Computertype.class);
    }
    
}
