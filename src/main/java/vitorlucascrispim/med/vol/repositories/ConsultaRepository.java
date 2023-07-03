package vitorlucascrispim.med.vol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitorlucascrispim.med.vol.models.consulta.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
}
