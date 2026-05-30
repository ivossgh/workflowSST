package sistema.sst.models;

import sistema.sst.models.enums.TipoServico;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "servicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servico {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT") // ← campo de texto longo, sem limite
    private String descricao;

    @Column(name = "preco_base", nullable = false)
    private BigDecimal precoBase;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoServico tipo;

    @Column(nullable = false)
    @Builder.Default 
    private boolean ativo = true; // padrão do Java (false). Use este valor (true) que eu escolhi.

    @Column(name = "data_cadastro", updatable = false)
    private LocalDateTime dataCadastro;

    @PrePersist
    public void prePersist(){
        this.dataCadastro = LocalDateTime.now();
    }
}
