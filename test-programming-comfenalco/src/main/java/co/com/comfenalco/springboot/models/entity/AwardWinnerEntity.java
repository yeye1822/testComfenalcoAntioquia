package co.com.comfenalco.springboot.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_AwardWinner")
public class AwardWinnerEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long idPersons;
	private long idPrize;
	private long amount;
	
	@Column(name="createDate")
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@PrePersist
	public void getCreateDate() {
		createDate =  new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdPersons() {
		return idPersons;
	}

	public void setIdPersons(long idPersons) {
		this.idPersons = idPersons;
	}

	public long getIdPrize() {
		return idPrize;
	}

	public void setIdPrize(long idPrize) {
		this.idPrize = idPrize;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
}
