package mappers;

import dtos.PersonDTO;
import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class PersonMapper {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public static int getPersonCount(){
        EntityManager em = getEntityManager();
        try{
            return (int)em.createQuery("SELECT COUNT(p) FROM Person p JOIN p.hobbies h WHERE h.name = :hobby").getSingleResult();
        }finally{
            em.close();
        }
    }

    public List<PersonDTO> findUsersByHobby(String hobbyName) {
        EntityManager em = getEntityManager();
        String queryString = "SELECT p " +
                "FROM Person p JOIN p.hobbies h " +
                "WHERE h.name = :hobbyName";
        TypedQuery<Person> query = em.createQuery(queryString, Person.class);
        query.setParameter("hobbyName", hobbyName);
        List<Person> resultList = query.getResultList();
        List<PersonDTO> resultDTOList = new ArrayList<>();
        for (Person person : resultList) {
            PersonDTO personDTO = new PersonDTO(person);
            resultDTOList.add(personDTO);
        }
        return resultDTOList;
    }



}
