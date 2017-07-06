/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import Modelo.Animal;
import util.JpaUtil;

/**
 *
 * @author anne
 */
public class AnimalDao extends CrudDao<Animal>{
    
    public AnimalDao() {
	super(Animal.class);
    }
    
    public List<Animal> listarNaoAdotados() {
    	EntityManager em = JpaUtil.getEntityManager();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Animal.class));
        List<Animal> lista = em.createQuery(cq).getResultList(); 
        for(Animal a: lista){
        	if(a.isStatus())
        		lista.remove(a);
        }
        return lista;
    }
    
    public List<Animal> listarPorUsuario(Long idUsuario) {
    	EntityManager em = JpaUtil.getEntityManager();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Animal.class));
        List<Animal> lista = em.createQuery(cq).getResultList(); 
        for(Animal a: lista){
        	if(a.getResponsavel().getId() != idUsuario)
        		lista.remove(a);
        }
        return lista;
    }
    
}
