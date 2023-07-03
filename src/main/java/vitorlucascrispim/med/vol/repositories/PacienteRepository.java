package vitorlucascrispim.med.vol.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitorlucascrispim.med.vol.models.paciente.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
