package sistema.sst.repositories;
import sistema.sst.models.enums.Setor;
import sistema.sst.models.enums.Status;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import sistema.sst.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID>{

    // Spring Data JPA gera o SQL automaticamente pelo nome do método!

    // SELECT * FROM clientes WHERE cnpj = ?
    Optional<Cliente>findByCnpj(String cnpj);

    // SELECT * FROM clientes WHERE telefone = ?
    Optional<Cliente>findByTelefone(String telefone);

    // SELECT * FROM clientes WHERE nome LIKE %?%
    List<Cliente>findByNomeContainingIgnoreCase(String nome);

    List<Cliente>findByCidade(String cidade);

    // SELECT COUNT(*) FROM clientes WHERE status = ?
    Long countByStatusEmpresa(Status statusEmpresa);

    Long countBySetorEmpresa(Setor setorEmpresa);

    // SELECT * FROM clientes WHERE status_empresa = ? ORDER BY nome ASC
    List<Cliente> findByStatusEmpresaOrderByNomeAsc(Status statusEmpresa);

}
