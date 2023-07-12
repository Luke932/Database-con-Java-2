package Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Getter
@Setter
@NoArgsConstructor
public class Persona {
	@Id
	@GeneratedValue
	private Long Id;
	private String Nome;
	private String Cognome;
	private String Email;
	private LocalDate DataNascita;

	@Enumerated(EnumType.STRING)
	private Sesso sesso;

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	@OrderBy("dataEvento ASC")
	private List<Partecipazione> ListaPartecipazioni;

	public Persona(String nome, String cognome, String email, CharSequence dataNascita, Sesso sesso) {
		Nome = nome;
		Cognome = cognome;
		Email = email;
		DataNascita = LocalDate.parse(dataNascita);
		this.sesso = sesso;
	}

	@Override
	public String toString() {
		return "Persona [Nome=" + Nome + ", Cognome=" + Cognome + ", Email=" + Email + ", DataNascita=" + DataNascita
				+ ", sesso=" + sesso + "]";
	}

}
