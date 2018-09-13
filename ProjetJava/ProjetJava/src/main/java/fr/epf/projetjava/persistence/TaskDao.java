package fr.epf.projetjava.persistence;

import fr.epf.projetjava.models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskDao extends CrudRepository<Task, Integer> {

}