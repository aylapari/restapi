/*
 * The Payments entity object
 */
package com.company.payments.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Payment.
 */
@Entity
public class Payment {

	/** The type. */
	private String type;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private String id;
	
	/** The version. */
	@JsonProperty("version")
	private Integer version;
	
	/** The organisation id. */
	@JsonProperty("organisation_id")
	private String organisationId;
	
	/** The attributes. */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attributes_id")
	@JsonProperty("attributes")
	@JsonManagedReference
	private Attributes attributes;

	/**
	 * Instantiates a new payment.
	 */
	public Payment() {
		
	}
	
	/**
	 * Instantiates a new payment.
	 *
	 * @param type the type
	 * @param id the id
	 * @param version the version
	 * @param organisationId the organisation id
	 * @param attributes the attributes
	 */
	public Payment(String type, String id, Integer version, String organisationId, Attributes attributes) {
		super();
		this.type = type;
		this.id = id;
		this.version = version;
		this.organisationId = organisationId;
		this.attributes = attributes;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * Gets the organisation id.
	 *
	 * @return the organisation id
	 */
	public String getOrganisationId() {
		return organisationId;
	}

	/**
	 * Sets the organisation id.
	 *
	 * @param organisationId the new organisation id
	 */
	public void setOrganisationId(String organisationId) {
		this.organisationId = organisationId;
	}

	/**
	 * Gets the attributes.
	 *
	 * @return the attributes
	 */
	public Attributes getAttributes() {
		return attributes;
	}

	/**
	 * Sets the attributes.
	 *
	 * @param attributes the new attributes
	 */
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("type", type).append("id", id).append("version", version)
				.append("organisationId", organisationId).append("attributes", attributes).toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(organisationId).append(attributes).append(type).append(version)
				.toHashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Payment) == false) {
			return false;
		}
		Payment rhs = ((Payment) other);
		return new EqualsBuilder().append(id, rhs.id).append(organisationId, rhs.organisationId)
				.append(attributes, rhs.attributes).append(type, rhs.type).append(version, rhs.version).isEquals();
	}

}