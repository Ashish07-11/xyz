package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.Data;
@Data
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;;
	private String language;
	private String genre;
	private double rating;
	@Column
	private String doj;

	@Lob
	private byte[] picture;
	
	
	
	
}
