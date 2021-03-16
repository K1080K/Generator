package magus.dao;

import magus.Encryption;
import magus.exceptions.WrongUserNameOrPasswordException;
import magus.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class UserDAO {
    private static SessionFactory factory;

    public UserDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void createUser(User user){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();
    }

    public User readUser(String name, String password) throws WrongUserNameOrPasswordException {
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery( "FROM User u JOIN FETCH u.characters WHERE u.name = :name AND u.password = :pw");

        query.setParameter("name", name);
        query.setParameter("pw", password);

        ArrayList<User> users = (ArrayList<User>) query.list();

        session.close();

        if (users.size() != 0){
            return users.get(0);
        }
        throw new WrongUserNameOrPasswordException();
    }
}
















