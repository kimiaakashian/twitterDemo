package ir.group_3_and_4.repository;

import ir.group_3_and_4.model.Twitt;
import ir.group_3_and_4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface TwittRepository extends JpaRepository<Twitt,Long> {

    List<Twitt> findTwittsByUser(User user);
}
