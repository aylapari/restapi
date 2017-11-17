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
 * The Class DebtorParty.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"account_name",
"account_number",
"account_number_code",
"address",
"bank_id",
"bank_id_code",
"name"
})
@Entity
public class DebtorParty {

	/** The id. */
	@Id 
    @GeneratedValue
    @JsonIgnore
    private long id;	

	
	/** The account name. */
	@JsonProperty("account_name")
	private String accountName;
	
	/** The account number. */
	@JsonProperty("account_number")
	private String accountNumber;
	
	/** The account number code. */
	@JsonProperty("account_number_code")
	private String accountNumberCode;
	
	/** The address. */
	@JsonProperty("address")
	private String address;
	
	/** The bank id. */
	@JsonProperty("bank_id")
	private String bankId;
	
	/** The bank id code. */
	@JsonProperty("bank_id_code")
	private String bankIdCode;
	
	/** The name. */
	@JsonProperty("name")
	private String name;

	/** The attributes. */
	@OneToOne(mappedBy = "debtorParty")
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
	 * Gets the account name.
	 *
	 * @return the account name
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * Sets the account name.
	 *
	 * @param accountName the new account name
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
	 * Gets the account number code.
	 *
	 * @return the account number code
	 */
	public String getAccountNumberCode() {
		return accountNumberCode;
	}

	/**
	 * Sets the account number code.
	 *
	 * @param accountNumberCode the new account number code
	 */
	public void setAccountNumberCode(String accountNumberCode) {
		this.accountNumberCode = accountNumberCode;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
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

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("accountName", accountName).append("accountNumber", accountNumber)
				.append("accountNumberCode", accountNumberCode).append("address", address).append("bankId", bankId)
				.append("bankIdCode", bankIdCode).append("name", name).toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(accountNumber).append(accountName).append(address).append(name)
				.append(accountNumberCode).append(bankIdCode).append(bankId).toHashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DebtorParty) == false) {
			return false;
		}
		DebtorParty rhs = ((DebtorParty) other);
		return new EqualsBuilder().append(accountNumber, rhs.accountNumber).append(accountName, rhs.accountName)
				.append(address, rhs.address).append(name, rhs.name).append(accountNumberCode, rhs.accountNumberCode)
				.append(bankIdCode, rhs.bankIdCode).append(bankId, rhs.bankId).isEquals();
	}

}