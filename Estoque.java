package poo;


public class Estoque {

    
    private int id;
    private String EAN;
    private String DESCRICAO;
    private int QUANTIDADE;
    private double VALOR; 

    public Estoque(String EAN, String DESCRICAO, int QUANTIDADE, double VALOR) {
       
        this.EAN = EAN;
        this.DESCRICAO = DESCRICAO;
        this.QUANTIDADE = QUANTIDADE;
        this.VALOR = VALOR;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEAN() {
        return EAN;
    }

    public void setEAN(String eAN) {
      
        this.EAN = eAN; 
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String dESCRICAO) {
        this.DESCRICAO = dESCRICAO;
    }

    public int getQUANTIDADE() {
        return QUANTIDADE;
    }

    public void setQUANTIDADE(int qUANTIDADE) {
        this.QUANTIDADE = qUANTIDADE;
    }

    public double getValor() {
        return VALOR;
    }

    public void setValor(double valor) {
      
        this.VALOR = valor; 
}
}