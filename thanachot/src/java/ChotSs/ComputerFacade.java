/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChotSs;

import Chot.Computer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Windows 8.1
 */
@Stateless
public class ComputerFacade extends AbstractFacade<Computer> {

    @PersistenceContext(unitName = "thanachotPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComputerFacade() {
        super(Computer.class);
    }
    
}
