package vitorlucascrispim.med.vol.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitorlucascrispim.med.vol.models.Medico;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long> {
    Page<Medico> findAllByAtivoTrue(Pageable pageable);
}
