package edu.csumb.project2backend.repositories;
import edu.csumb.project2backend.entities.Items;
import edu.csumb.project2backend.entities.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepo extends CrudRepository<Items, Long> {

    List<Items> findByUser(User user);
}

