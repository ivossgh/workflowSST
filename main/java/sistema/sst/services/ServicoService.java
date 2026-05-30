package sistema.sst.services;

import java.util.List;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sistema.sst.models.Servico;
import sistema.sst.models.enums.TipoServico;
import sistema.sst.repositories.ServicoRepository;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public List<Servico> listarTodos(){
        return servicoRepository.findAll();
    }

    public Servico buscarPorId(Long Id){
        return servicoRepository.findById(Id)
        .orElseThrow(() -> new RuntimeException("Servico nao encontrado"));
    } 

    public Servico salvar(Servico servico){
        return servicoRepository.save(servico);
    }

    public void excluir(Long id){
        // 1. Busca o serviço (reutilizando o seu método buscarPorId)
        Servico servico = buscarPorId(id);
        // 2. Em vez de apagar do banco, apenas desativa
        servico.setAtivo(false);
        // 3. Salva a alteração. O JPA vai entender que é um UPDATE
        servicoRepository.save(servico);
    }

    public List<Servico> listarAtivos(){
        return servicoRepository.findByAtivoTrue();
    }

    public List<Servico> listarInativos(){
        return servicoRepository.findByAtivoFalse();
    }

    public List<Servico> listarTipo(TipoServico tipo){
        return servicoRepository.findByTipoAndAtivoTrue(tipo);
    }
}
