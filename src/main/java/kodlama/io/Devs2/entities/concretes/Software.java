package kodlama.io.Devs2.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "softwares")
public class Software {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "software", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = SoftwareTechnologies.class)
	private List<SoftwareTechnologies> softwareTechnologies;

	@Override
	public String toString() {
		return "Software : { id : " + getId() + " name : " + getName() + " }";
	}

}
