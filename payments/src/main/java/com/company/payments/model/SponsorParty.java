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
 * The Class SponsorParty.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"account_number",
"bank_id",
"bank_id_code"
})
@Entity
public class SponsorParty {

	/** The id. */
	@Id 
    @GeneratedValue
    @JsonIgnore
    private long id;	

	/** The attributes. */
	@OneToOne(mappedBy = "sponsorParty")
	@JsonBackReference
	private Attributes attributes;	
	
	/** The account number. */
	@JsonProperty("account_number")
	private String accountNumber;
	
	/** The bank id. */
	@JsonProperty("bank_id")
	private String bankId;
	
	/** The bank id code. */
	@JsonProperty("bank_id_code")
	private String bankIdCode;

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

	/**
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets the account number.
	 *
	 * @param accountNumber the new account number
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Gets the bank id.
	 *
	 * @return the bank id
	 */
	public String getBankId() {
		return bankId;
	}

	/**
	 * Sets the bank id.
	 *
	 * @param bankId the new bank id
	 */
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	/**
	 * Gets the bank id code.
	 *
	 * @return the bank id code
	 */
	public String getBankIdCode() {
		return bankIdCode;
	}

	/**
	 * Sets the bank id code.
	 *
	 * @param bankIdCode the new bank id code
	 */
	public void setBankIdCode(String bankIdCode) {
		this.bankIdCode = bankIdCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("accountNumber", accountNumber).append("bankId", bankId)
				.append("bankIdCode", bankIdCode).toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(accountNumber).append(bankIdCode).append(bankId).toHashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof SponsorParty) == false) {
			return false;
		}
		SponsorParty rhs = ((SponsorParty) other);
		return new EqualsBuilder().append(accountNumber, rhs.accountNumber).append(bankIdCode, rhs.bankIdCode)
				.append(bankId, rhs.bankId).isEquals();
	}

}