/*
 * 
 */
package com.company.payments.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Class ChargesInformation.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"bearer_code",
"sender_charges",
"receiver_charges_amount",
"receiver_charges_currency"
})
@Entity
public class ChargesInformation {

	/** The id. */
	@Id 
    @GeneratedValue
    @JsonIgnore
    private long id;	

	/** The bearer code. */
	@JsonProperty("bearer_code")
	private String bearerCode;
	
	
	/** The sender charges. */
	@OneToMany(mappedBy="chargesInformation")
	@ElementCollection(targetClass=SenderCharge.class)
	@JsonProperty("sender_charges")
	@JsonManagedReference
	private List<SenderCharge> senderCharges = null;
	
	/** The receiver charges amount. */
	@JsonProperty("receiver_charges_amount")
	private String receiverChargesAmount;
	
	/** The receiver charges currency. */
	@JsonProperty("receiver_charges_currency")
	private String receiverChargesCurrency;

	/** The attributes. */
	@OneToOne(mappedBy = "chargesInformation")
	@JsonBackReference
	private Attributes attributes;		
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the bearer code.
	 *
	 * @return the bearer code
	 */
	public String getBearerCode() {
		return bearerCode;
	}

	/**
	 * Sets the bearer code.
	 *
	 * @param bearerCode the new bearer code
	 */
	public void setBearerCode(String bearerCode) {
		this.bearerCode = bearerCode;
	}

	/**
	 * Gets the sender charges.
	 *
	 * @return the sender charges
	 */
	public List<SenderCharge> getSenderCharges() {
		return senderCharges;
	}

	/**
	 * Sets the sender charges.
	 *
	 * @param senderCharges the new sender charges
	 */
	public void setSenderCharges(List<SenderCharge> senderCharges) {
		this.senderCharges = senderCharges;
	}

	/**
	 * Gets the receiver charges amount.
	 *
	 * @return the receiver charges amount
	 */
	public String getReceiverChargesAmount() {
		return receiverChargesAmount;
	}

	/**
	 * Sets the receiver charges amount.
	 *
	 * @param receiverChargesAmount the new receiver charges amount
	 */
	public void setReceiverChargesAmount(String receiverChargesAmount) {
		this.receiverChargesAmount = receiverChargesAmount;
	}

	/**
	 * Gets the receiver charges currency.
	 *
	 * @return the receiver charges currency
	 */
	public String getReceiverChargesCurrency() {
		return receiverChargesCurrency;
	}

	/**
	 * Sets the receiver charges currency.
	 *
	 * @param receiverChargesCurrency the new receiver charges currency
	 */
	public void setReceiverChargesCurrency(String receiverChargesCurrency) {
		this.receiverChargesCurrency = receiverChargesCurrency;
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
		return new ToStringBuilder(this).append("bearerCode", bearerCode).append("senderCharges", senderCharges)
				.append("receiverChargesAmount", receiverChargesAmount)
				.append("receiverChargesCurrency", receiverChargesCurrency).toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(receiverChargesAmount).append(receiverChargesCurrency).append(bearerCode)
				.append(senderCharges).toHashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof ChargesInformation) == false) {
			return false;
		}
		ChargesInformation rhs = ((ChargesInformation) other);
		return new EqualsBuilder().append(receiverChargesAmount, rhs.receiverChargesAmount)
				.append(receiverChargesCurrency, rhs.receiverChargesCurrency).append(bearerCode, rhs.bearerCode)
				.append(senderCharges, rhs.senderCharges).isEquals();
	}

}