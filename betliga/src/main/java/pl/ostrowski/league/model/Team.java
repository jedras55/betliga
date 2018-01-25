package pl.ostrowski.league.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/** Created by Jedras-PC on 24.01.2018. */
@Data
@Entity
public class Team {
  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  private String id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "leagueId")
  private League league;
}
