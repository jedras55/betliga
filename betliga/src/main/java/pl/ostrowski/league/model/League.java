package pl.ostrowski.league.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/** Created by Jedras-PC on 24.01.2018. */
@Data
@Entity
public class League {
  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  private String id;
  private String name;
  @OneToMany(mappedBy = "league")
  List<Team> teams;
}
