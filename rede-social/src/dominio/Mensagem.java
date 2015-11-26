package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_mensagens")
public class Mensagem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idConversa;
	private String conversa;
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="remetente")
	private Usuario enviadas;
	@ManyToOne
	@JoinColumn(name="destinatario")
	private Usuario recebidas;
	
	public Mensagem(){
		
	}

	public Mensagem(Integer idConversa, String conversa, Date data, Usuario enviadas, Usuario recebidas) {
		this.idConversa = idConversa;
		this.conversa = conversa;
		this.data = data;
		this.enviadas = enviadas;
		this.recebidas = recebidas;
	}

	public Integer getIdConversa() {
		return idConversa;
	}

	public void setIdConversa(Integer idConversa) {
		this.idConversa = idConversa;
	}

	public String getConversa() {
		return conversa;
	}

	public void setConversa(String conversa) {
		this.conversa = conversa;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getEnviadas() {
		return enviadas;
	}

	public void setEnviadas(Usuario enviadas) {
		this.enviadas = enviadas;
	}

	public Usuario getRecebidas() {
		return recebidas;
	}

	public void setRecebidas(Usuario recebidas) {
		this.recebidas = recebidas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConversa == null) ? 0 : idConversa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensagem other = (Mensagem) obj;
		if (idConversa == null) {
			if (other.idConversa != null)
				return false;
		} else if (!idConversa.equals(other.idConversa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mensagem [idConversa=" + idConversa + ", data=" + data + ", conversa=" + conversa + "]";
	}

		

}
