package sistema.sst.models;
import sistema.sst.models.enums.Setor;
import sistema.sst.models.enums.Status;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cnpj", nullable = false, unique = true, length = 18)
    private String cnpj;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Setor setorEmpresa; 

    @Column(name = "data_cadastro")
    private LocalDateTime cadastro;

    @Column(name = "data_atualizacao")
    private LocalDateTime atualizacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status statusEmpresa; 


    @PrePersist
    public void prePersist(){
        this.cadastro = LocalDateTime.now();
        this.atualizacao = LocalDateTime.now();
        if(this.statusEmpresa == null){
            this.statusEmpresa = Status.ATIVO;
        }
    }

    @PreUpdate
    public void preUpdate(){
        this.atualizacao = LocalDateTime.now();
    }
}
