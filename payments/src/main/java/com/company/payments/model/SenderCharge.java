/*
 * 
 */
package com.company.payments.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Class SenderCharge.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"amount",
"currency"
})
@Entity
public class SenderCharge {

	/** The id. */
	@Id 
    @GeneratedValue
    @JsonIgnore
    private long id;	

    /** The charges information. */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sender_id")
    @JsonBackReference
	private ChargesInformation chargesInformation;	
	
    /** The amount. */
    @JsonProperty("amount")
    private String amount;
    
    /** The currency. */
    @JsonProperty("currency")
    private String currency;

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
	 * Gets the charges information.
	 *
	 * @return the charges information
	 */
	public ChargesInformation getChargesInformation() {
		return chargesInformation;
	}

	/**
	 * Sets the charges information.
	 *
	 * @param chargesInformation the new charges information
	 */
	public void setChargesInformation(ChargesInformation chargesInformation) {
		this.chargesInformation = chargesInformation;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("amount", amount).append("currency", currency).toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(amount).append(currency).toHashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof SenderCharge) == false) {
			return false;
		}
		SenderCharge rhs = ((SenderCharge) other);
		return new EqualsBuilder().append(amount, rhs.amount).append(currency, rhs.currency).isEquals();
	}

}