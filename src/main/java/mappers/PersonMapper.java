package mappers;

import entities.Hobby;
import entities.Person;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class PersonMapper {


    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();


    public List<Person> getPeopleByHobby(Hobby hobby){
        ArrayList<Person> people = new ArrayList();

        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p JOIN p.hobbies h WHERE h.name = :hobbyName", Person.class);



        return people;
    }
}
