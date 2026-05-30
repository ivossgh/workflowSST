package sistema.sst.models.enums;

public enum Status {
    ATIVO("Ativo"), // cliente ativo, pode receber propostas
    INATIVO("Inativo"), // cliente pausado temporariamente
    PROSPECTADO("Prospectado"); // ainda não é cliente, está sendo captado
    
    private final String descricao;

    // O construtor deve ter o mesmo nome do Enum
    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
