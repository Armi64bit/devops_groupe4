package tn.esprit.devopsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devopsproject.entities.ActivitySector;

public interface ActivitySectorRepository extends JpaRepository<ActivitySector, Long> {
}
