package app;

import entity.Books;
import entity.DestinatieTuristica;
import entity.UserE;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.util.List;

import static util.HibernateUtil.*;

public class Main {

    public static void main(String[] args) {


        UserE user1 = new UserE();
        user1.setEmail("user1@user1.com");
        user1.setLn("User1");
        user1.setFn("Us1");


        save(user1);

        List<UserE> allUsers = readAll(UserE.class);
        List<UserE> users = findAllByFnAndLn("user1", "us1");

        System.out.println("Found" + users.size() + "users");

            for(UserE e: users){
                System.out.println(e);
            }

            closeEMF();

        Books book1 = new Books();
        book1.setISBN(1234);
        book1.setTitlu("Vin ploile");
        book1.setAutor("nu mai stiu");
        book1.setAnAparitie("1980");

       // save(book1);

        DestinatieTuristica dest1 = new DestinatieTuristica();

        dest1.setCoordonate(1589);
        dest1.setOras("Berlin");
        dest1.setObiectiv("Pergamom");

      //  save(dest1);

    }

    public static List findAllByFnAndLn (String fn, String ln){
        List users = null;

        EntityManager manager = getEM();

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<Object> query =  builder.createQuery();
        Root<UserE> root = query.from(UserE.class);
        query.select(root);

        query.where(builder.and(builder.equal(root.get("fn"), fn),
        builder.equal(root.get("ln"), ln)
          )
        );
        users = manager.createQuery(query).getResultList();
        manager.close();
        return users;

    }
}
