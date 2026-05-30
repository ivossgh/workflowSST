package sistema.sst.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema.sst.models.Servico;
import sistema.sst.models.enums.TipoServico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

    List<Servico> findByAtivoTrue();

    List<Servico> findByAtivoFalse();

    List<Servico> findByTipoAndAtivoTrue(TipoServico tipo);
}
