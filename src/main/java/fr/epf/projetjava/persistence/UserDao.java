package fr.epf.projetjava.persistence;

import fr.epf.projetjava.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 10/09/2018
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
  
}
