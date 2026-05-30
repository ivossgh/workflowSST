package sistema.sst.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoServico {
    ELABORACAO_PGR("Elaboração de PGR (Prog. de Gerenciamento de Riscos)"),
    ELABORACAO_PCMSO("Elaboração de PCMSO (Saúde Ocupacional)"),
    LAUDO_LT_CAT("Emissão de LTCAT (Laudo Técnico)"),
    TREINAMENTO_NR("Treinamento de Normas Regulamentadoras (NRs)"),
    INSPECAO_SEGURANCA("Inspeção de Segurança no Trabalho"),
    OUTRO("Outros Serviços");

    private final String descricao;
}   