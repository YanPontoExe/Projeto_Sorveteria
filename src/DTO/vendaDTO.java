package DTO;
public class vendaDTO {

    /**
     * @return the qtd_venda
     */
    public int getQtd_venda() {
        return qtd_venda;
    }

    /**
     * @param qtd_venda the qtd_venda to set
     */
    public void setQtd_venda(int qtd_venda) {
        this.qtd_venda = qtd_venda;
    }

    /**
     * @return the item_venda
     */
    public int getItem_venda() {
        return item_venda;
    }

    /**
     * @param item_venda the item_venda to set
     */
    public void setItem_venda(int item_venda) {
        this.item_venda = item_venda;
    }

    /**
     * @return the nome_cliente
     */
    public String getNome_cliente() {
        return nome_cliente;
    }

    /**
     * @param nome_cliente the nome_cliente to set
     */
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }
    private int id_venda, qtd_venda, cod_funcionario, item_venda, cod_cliente;
    private String hora_venda, data_venda, valor_venda, nome_cliente;

    /**
     * @return the id_venda
     */
    public int getId_venda() {
        return id_venda;
    }

    /**
     * @param id_venda the id_venda to set
     */
    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    /**
     * @return the cod_funcionario
     */
    public int getCod_funcionario() {
        return cod_funcionario;
    }

    /**
     * @param cod_funcionario the cod_funcionario to set
     */
    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    /**
     * @return the cod_cliente
     */
    

    /**
     * @return the hora_venda
     */
    public String getHora_venda() {
        return hora_venda;
    }

    /**
     * @param hora_venda the hora_venda to set
     */
    public void setHora_venda(String hora_venda) {
        this.hora_venda = hora_venda;
    }

    /**
     * @return the data_venda
     */
    public String getData_venda() {
        return data_venda;
    }

    /**
     * @param data_venda the data_venda to set
     */
    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    /**
     * @return the cod_cliente
     */
    public int getCod_cliente() {
        return cod_cliente;
    }

    /**
     * @param cod_cliente the cod_cliente to set
     */
    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    /**
     * @return the valor_venda
     */
    public String getValor_venda() {
        return valor_venda;
    }

    /**
     * @param valor_venda the valor_venda to set
     */
    public void setValor_venda(String valor_venda) {
        this.valor_venda = valor_venda;
    }
}
