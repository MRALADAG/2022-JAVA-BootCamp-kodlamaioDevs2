package kodlama.io.Devs2.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "softwares_technologies")
public class SoftwareTechnologies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToOne(targetEntity = Software.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "software_id")
	private Software software;

	@Override
	public String toString() {
		return "Software Technologies : { id : " + getId() + " name : " + getName() + " }";
	}

}
