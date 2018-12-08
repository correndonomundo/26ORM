package util;

import entity.UserE;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class HibernateUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORM");

    public static EntityManager getEM(){
        return emf.createEntityManager();
    }

    public static <Entity extends Serializable> void save(Entity e){
        EntityManager em = getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(e);
        t.commit();
        em.close();
    }

    public static <Entity extends Serializable> List <Entity> readAll(Class<Entity> entityClass){
        List<Entity> entities = null;
        EntityManager manager = getEM();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery();
        Root<javax.persistence.Entity> root = query.from(entityClass);
        query.select(root);
        entities = manager.createQuery(query).getResultList();
        manager.close();
        return entities;

    }

    public static <Entity extends Serializable> void update(int id, String fn, String ln){
        EntityManager em = getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        UserE user = em.find(UserE.class, id);
        user.setFn(fn);
        user.setLn(ln);
        em.persist(user);
        t.commit();
        em.close();
    }

    public static <Entity extends Serializable> void delete (int id){
        EntityManager em = getEM();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();

            UserE user = em.find(UserE.class, id);
            em.remove(user);
            transaction.commit();
        }catch (Exception e1){
            if(transaction != null) {
                transaction.rollback();
            }
                e1.printStackTrace();
            }finally{

        em.close();
        }
    }

    public static void closeEMF(){
        emf.close();
    }
}
