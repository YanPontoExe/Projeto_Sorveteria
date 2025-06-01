package DTO;
public class funcionarioDTO {
    private String nome_funcionario, cpf_funcionario;
    private int id_funcionario;

    /**
     * @return the nome_funcionario
     */
    public String getNome_funcionario() {
        return nome_funcionario;
    }

    /**
     * @param nome_funcionario the nome_funcionario to set
     */
    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    /**
     * @return the cpf_funcionario
     */
    public String getCpf_funcionario() {
        return cpf_funcionario;
    }

    /**
     * @param cpf_funcionario the cpf_funcionario to set
     */
    public void setCpf_funcionario(String cpf_funcionario) {
        this.cpf_funcionario = cpf_funcionario;
    }

    /**
     * @return the id_funcionario
     */
    public int getId_funcionario() {
        return id_funcionario;
    }

    /**
     * @param id_funcionario the id_funcionario to set
     */
    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
}
