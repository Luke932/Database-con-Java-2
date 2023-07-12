package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue

	private Long Id;
	private String Nome;
	private String Citta;

	public Location(String nome, String citta) {
		Nome = nome;
		Citta = citta;
	}

	@Override
	public String toString() {
		return "Location [Nome=" + Nome + ", Citta=" + Citta + "]";
	}

}
