package mappers;

import dtos.PostalCodeDTO;
import entities.CityInfo;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PostalCodeMapper {


    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();

    public static List<PostalCodeDTO> getPostalCodes(){
        EntityManager em = emf.createEntityManager();
        ArrayList<PostalCodeDTO> postalCodes = new ArrayList();
        Query query = em.createNamedQuery("CityInfo.findByOrderByCityDesc");
        List<CityInfo> rs = query.getResultList();
        for(CityInfo p : rs){
            PostalCodeDTO pDTO = new PostalCodeDTO(p);
            postalCodes.add(pDTO);
        }
        return postalCodes;
    }

}
