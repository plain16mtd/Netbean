/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChotSs;

import Chot.Computeruser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Windows 8.1
 */
@Stateless
public class ComputeruserFacade extends AbstractFacade<Computeruser> {

    @PersistenceContext(unitName = "thanachotPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComputeruserFacade() {
        super(Computeruser.class);
    }
    
}
