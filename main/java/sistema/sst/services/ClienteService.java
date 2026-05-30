package sistema.sst.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sistema.sst.models.Cliente;
import sistema.sst.models.enums.Setor;
import sistema.sst.models.enums.Status;
import sistema.sst.repositories.ClienteRepository;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(UUID Id){
        return clienteRepository.findById(Id).
        orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
    }

    public Cliente salvar(Cliente cliente) {
        clienteRepository.findByCnpj(cliente.getCnpj())
            .ifPresent(clienteExistente -> {
                // Se nao forem iguais eu salvo, se for igual eu lanço a excessao
                if (!clienteExistente.getId().equals(cliente.getId())) {
                    throw new RuntimeException("CNPJ já cadastrado: " + cliente.getCnpj());
                }
            });

        return clienteRepository.save(cliente);
    }

    public void excluir(UUID id) {
        Cliente cliente = buscarPorId(id); // Garante que o cliente existe antes de tentar deletar
        clienteRepository.delete(cliente);
    }


    public Cliente buscarPorCnpj(String cnpj){
        return clienteRepository.findByCnpj(cnpj)
        .orElseThrow(() -> new RuntimeException("Cliente nao encontrado" + cnpj));
    }

    public void inativar(UUID id){
        Cliente cliente = buscarPorId(id);
        cliente.setStatusEmpresa(Status.INATIVO);
        clienteRepository.save(cliente);
    }

    public List<Cliente> listarAtivos(){
        return clienteRepository.findByStatusEmpresaOrderByNomeAsc(Status.ATIVO);
    }

    public List<Cliente> buscarPorNome(String nome){
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Cliente> buscarPorCidade(String cidade) {
        return clienteRepository.findByCidade(cidade);
    }

    // Para o Dash

    public Long contarPorStatus(Status statusEmpresa) {
        return clienteRepository.countByStatusEmpresa(statusEmpresa);
    }

    public Long contarPorSetor(Setor setorEmpresa) {
        return clienteRepository.countBySetorEmpresa(setorEmpresa);
    }
}
