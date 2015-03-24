/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.suivifinal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author medoune
 */
@Stateless
public class AntecedantFacade extends AbstractFacade<Antecedant> {
    @PersistenceContext(unitName = "com.mycompany_suiviFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AntecedantFacade() {
        super(Antecedant.class);
    }
    
}
