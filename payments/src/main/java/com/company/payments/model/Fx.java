/*
 * 
 */
package com.company.payments.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
 * The Class Fx.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"contract_reference",
"exchange_rate",
"original_amount",
"original_currency"
})
@Entity
public class Fx {

	/** The id. */
	@Id 
    @GeneratedValue
    @JsonIgnore
    private long id;	

	/** The attributes. */
	@OneToOne(mappedBy = "fx")
	@JsonBackReference
	private Attributes attributes;		
	
	/** The contract reference. */
	@JsonProperty("contract_reference")
	private String contractReference;
	
	/** The exchange rate. */
	@JsonProperty("exchange_rate")
	private String exchangeRate;
	
	/** The original amount. */
	@JsonProperty("original_amount")
	private String originalAmount;
	
	/** The original currency. */
	@JsonProperty("original_currency")
	private String originalCurrency;

	
	
	
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
	 * Gets the contract reference.
	 *
	 * @return the contract reference
	 */
	public String getContractReference() {
		return contractReference;
	}

	/**
	 * Sets the contract reference.
	 *
	 * @param contractReference the new contract reference
	 */
	public void setContractReference(String contractReference) {
		this.contractReference = contractReference;
	}

	/**
	 * Gets the exchange rate.
	 *
	 * @return the exchange rate
	 */
	public String getExchangeRate() {
		return exchangeRate;
	}

	/**
	 * Sets the exchange rate.
	 *
	 * @param exchangeRate the new exchange rate
	 */
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	/**
	 * Gets the original amount.
	 *
	 * @return the original amount
	 */
	public String getOriginalAmount() {
		return originalAmount;
	}

	/**
	 * Sets the original amount.
	 *
	 * @param originalAmount the new original amount
	 */
	public void setOriginalAmount(String originalAmount) {
		this.originalAmount = originalAmount;
	}

	/**
	 * Gets the original currency.
	 *
	 * @return the original currency
	 */
	public String getOriginalCurrency() {
		return originalCurrency;
	}

	/**
	 * Sets the original currency.
	 *
	 * @param originalCurrency the new original currency
	 */
	public void setOriginalCurrency(String originalCurrency) {
		this.originalCurrency = originalCurrency;
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
		return new ToStringBuilder(this).append("contractReference", contractReference)
				.append("exchangeRate", exchangeRate).append("originalAmount", originalAmount)
				.append("originalCurrency", originalCurrency).toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(originalCurrency).append(originalAmount).append(exchangeRate)
				.append(contractReference).toHashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Fx) == false) {
			return false;
		}
		Fx rhs = ((Fx) other);
		return new EqualsBuilder().append(originalCurrency, rhs.originalCurrency)
				.append(originalAmount, rhs.originalAmount).append(exchangeRate, rhs.exchangeRate)
				.append(contractReference, rhs.contractReference).isEquals();
	}

}