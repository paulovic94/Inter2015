package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="tb_amizades")
public class Amizade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAmizade;
	private Date dataInicio;
	
	@ManyToOne
	@JoinColumn(name="seguidor")
	private Usuario seguidor;	
	
	@ManyToOne
	@JoinColumn(name="seguido")
	private Usuario seguido;
	
	
	public Amizade(){
		
	}

	public Amizade(Integer idAmizade, Date dataInicio, Usuario seguido, Usuario seguidor) {
		this.idAmizade = idAmizade;
		this.dataInicio = dataInicio;
		this.seguido = seguido;
		this.seguidor = seguidor;
	}

	public Integer getIdAmizade() {
		return idAmizade;
	}

	public void setIdAmizade(Integer idAmizade) {
		this.idAmizade = idAmizade;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Usuario getSeguido() {
		return seguido;
	}

	public void setSeguido(Usuario seguido) {
		this.seguido = seguido;
	}

	public Usuario getSeguidor() {
		return seguidor;
	}

	public void setSeguidor(Usuario seguidor) {
		this.seguidor = seguidor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAmizade == null) ? 0 : idAmizade.hashCode());
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
		Amizade other = (Amizade) obj;
		if (idAmizade == null) {
			if (other.idAmizade != null)
				return false;
		} else if (!idAmizade.equals(other.idAmizade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Amizade [idAmizade=" + idAmizade + ", dataInicio=" + dataInicio + "]";
	}	

}
