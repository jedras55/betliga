package pl.ostrowski.league.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ostrowski.league.model.Team;

/**
 * Created by Jedras-PC on 24.01.2018.
 */
public interface TeamRepository extends JpaRepository<Team, String>{
}
