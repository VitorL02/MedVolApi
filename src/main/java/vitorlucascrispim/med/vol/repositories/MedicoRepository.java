package vitorlucascrispim.med.vol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitorlucascrispim.med.vol.models.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long> {
}
