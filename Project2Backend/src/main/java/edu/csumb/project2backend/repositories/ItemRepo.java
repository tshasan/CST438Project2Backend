package edu.csumb.project2backend.repositories;
import edu.csumb.project2backend.entities.Items;
import edu.csumb.project2backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemRepo extends JpaRepository<Items, Long> {
    List<Items> findByUser(User user);
}
