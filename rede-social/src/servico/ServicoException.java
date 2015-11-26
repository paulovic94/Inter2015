package servico;

public class ServicoException extends Exception {

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	
	public ServicoException(String msg, Integer codigo) {
		
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
