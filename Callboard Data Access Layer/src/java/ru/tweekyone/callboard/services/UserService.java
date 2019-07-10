package ru.tweekyone.callboard.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import ru.tweekyone.callboard.entities.User;

/**
 *
 * @author Пирожок
 */

@Stateless
public class UserService {
    
    @PersistenceContext(unitName = "CallboardPU")
    EntityManager em;
    
    public void create(User user){
        em.persist(user); //merge для изменения
        em.flush();
    }
    
    public User findByName(String name){
        try{
            return em.createNamedQuery("find-user-by-name", User.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }
}
