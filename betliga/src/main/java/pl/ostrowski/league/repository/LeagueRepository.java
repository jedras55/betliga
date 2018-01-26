package pl.ostrowski.league.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ostrowski.league.model.League;

/**
 * Created by Jedras-PC on 24.01.2018.
 */
public interface LeagueRepository extends JpaRepository<League, String> {
}
