package facades;

import dtos.PersonDTO;
import entities.Person;
import entities.RenameMe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private PersonFacade() {}


    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
//
//    public PersonDTO create(PersonDTO personDTO){
//        Person person = new Person(personDTO.getFirstName(), personDTO.getLastName(), personDTO.getPhone());
//        EntityManager em = getEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.persist(rme);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//        return new PersonDTO();
//    }

}
