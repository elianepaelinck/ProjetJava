package fr.epf.projetjava.persistence;

import fr.epf.projetjava.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectDao extends CrudRepository<Project, Integer> {

}

