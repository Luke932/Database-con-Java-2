package Entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "partecipazione")
public class Partecipazione {
	@Id
	@GeneratedValue

	private Long Id;

	@ManyToOne
	private Persona persona;

	@ManyToOne
	private Evento evento;

	@Enumerated(EnumType.STRING)
	private Stato stato;

	public Partecipazione(Persona persona, Evento evento, Stato stato) {
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Partecipazione [persona=" + persona + ", evento=" + evento + ", stato=" + stato + "]";
	}

}
