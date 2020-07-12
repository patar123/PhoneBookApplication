 package com.ashokit.contactEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CONTACT_DTLS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity {
	@Id
	@Column(name="CONTACT_ID")
	@SequenceGenerator(
			name="cid_seq_gen",
			sequenceName="CONTACT_ID_SEQ",
			allocationSize=1
	)
	@GeneratedValue(
			generator="cid_seq_gen",
			strategy=GenerationType.SEQUENCE
	)
	Integer contactId;
	
	@Column(name="CONTACT_NAME")
	String contactName;
	
	@Column(name="CONTACT_EMAIL")
	String contactEmail;
	
	@Column(name="CONTACT_NUMBER")
	Long contactNumber;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE",updatable = false)
	Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE",insertable = false)
	Date updatedDate;

}
