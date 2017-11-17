/*
 * 
 */
package com.company.payments.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * The Class Attributes.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"amount",
"beneficiary_party",
"charges_information",
"currency",
"debtor_party",
"end_to_end_reference",
"fx",
"numeric_reference",
"payment_id",
"payment_purpose",
"payment_scheme",
"payment_type",
"processing_date",
"reference",
"scheme_payment_sub_type",
"scheme_payment_type",
"sponsor_party"
})
@Entity
public class Attributes {

	/** The id. */
	@Id 
    @GeneratedValue
    @JsonIgnore
    private long id;	
	
	/** The amount. */
	@JsonProperty("amount")
	private String amount;
	
	/** The beneficiary party. */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
	@JsonProperty("beneficiary_party")
	@JsonManagedReference
	private BeneficiaryParty beneficiaryParty;
	
	/** The charges information. */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "charges_id")
	@JsonProperty("charges_information")
	@JsonManagedReference
	private ChargesInformation chargesInformation;
	
	/** The currency. */
	@JsonProperty("currency")
	private String currency;
	
	/** The debtor party. */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debtor_id")
	@JsonProperty("debtor_party")
	@JsonManagedReference
	private DebtorParty debtorParty;
	
	/** The end to end reference. */
	@JsonProperty("end_to_end_reference")
	private String endToEndReference;
	
	/** The fx. */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fx_id")	
	@JsonProperty("fx")
	@JsonManagedReference
	private Fx fx;
	
	/** The numeric reference. */
	@JsonProperty("numeric_reference")
	private String numericReference;
	
	/** The payment id. */
	@JsonProperty("payment_id")
	private String paymentId;
	
	/** The payment purpose. */
	@JsonProperty("payment_purpose")
	private String paymentPurpose;
	
	/** The payment scheme. */
	@JsonProperty("payment_scheme")
	private String paymentScheme;
	
	/** The payment type. */
	@JsonProperty("payment_type")
	private String paymentType;
	
	/** The processing date. */
	@JsonProperty("processing_date")
	private String processingDate;
	
	/** The reference. */
	@JsonProperty("reference")
	private String reference;
	
	/** The scheme payment sub type. */
	@JsonProperty("scheme_payment_sub_type")
	private String schemePaymentSubType;
	
	/** The scheme payment type. */
	@JsonProperty("scheme_payment_type")
	private String schemePaymentType;
	
	/** The sponsor party. */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sponsor_id")
	@JsonProperty("sponsor_party")
	@JsonManagedReference
	private SponsorParty sponsorParty;
	
	/** The payment. */
	@OneToOne(mappedBy = "attributes")
	@JsonBackReference
	private Payment payment;

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
	 * Gets the beneficiary party.
	 *
	 * @return the beneficiary party
	 */
	public BeneficiaryParty getBeneficiaryParty() {
		return beneficiaryParty;
	}

	/**
	 * Sets the beneficiary party.
	 *
	 * @param beneficiaryParty the new beneficiary party
	 */
	public void setBeneficiaryParty(BeneficiaryParty beneficiaryParty) {
		this.beneficiaryParty = beneficiaryParty;
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

	/**
	 * Gets the debtor party.
	 *
	 * @return the debtor party
	 */
	public DebtorParty getDebtorParty() {
		return debtorParty;
	}

	/**
	 * Sets the debtor party.
	 *
	 * @param debtorParty the new debtor party
	 */
	public void setDebtorParty(DebtorParty debtorParty) {
		this.debtorParty = debtorParty;
	}

	/**
	 * Gets the end to end reference.
	 *
	 * @return the end to end reference
	 */
	public String getEndToEndReference() {
		return endToEndReference;
	}

	/**
	 * Sets the end to end reference.
	 *
	 * @param endToEndReference the new end to end reference
	 */
	public void setEndToEndReference(String endToEndReference) {
		this.endToEndReference = endToEndReference;
	}

	/**
	 * Gets the fx.
	 *
	 * @return the fx
	 */
	public Fx getFx() {
		return fx;
	}

	/**
	 * Sets the fx.
	 *
	 * @param fx the new fx
	 */
	public void setFx(Fx fx) {
		this.fx = fx;
	}

	/**
	 * Gets the numeric reference.
	 *
	 * @return the numeric reference
	 */
	public String getNumericReference() {
		return numericReference;
	}

	/**
	 * Sets the numeric reference.
	 *
	 * @param numericReference the new numeric reference
	 */
	public void setNumericReference(String numericReference) {
		this.numericReference = numericReference;
	}

	/**
	 * Gets the payment id.
	 *
	 * @return the payment id
	 */
	public String getPaymentId() {
		return paymentId;
	}

	/**
	 * Sets the payment id.
	 *
	 * @param paymentId the new payment id
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * Gets the payment purpose.
	 *
	 * @return the payment purpose
	 */
	public String getPaymentPurpose() {
		return paymentPurpose;
	}

	/**
	 * Sets the payment purpose.
	 *
	 * @param paymentPurpose the new payment purpose
	 */
	public void setPaymentPurpose(String paymentPurpose) {
		this.paymentPurpose = paymentPurpose;
	}

	/**
	 * Gets the payment scheme.
	 *
	 * @return the payment scheme
	 */
	public String getPaymentScheme() {
		return paymentScheme;
	}

	/**
	 * Sets the payment scheme.
	 *
	 * @param paymentScheme the new payment scheme
	 */
	public void setPaymentScheme(String paymentScheme) {
		this.paymentScheme = paymentScheme;
	}

	/**
	 * Gets the payment type.
	 *
	 * @return the payment type
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * Sets the payment type.
	 *
	 * @param paymentType the new payment type
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * Gets the processing date.
	 *
	 * @return the processing date
	 */
	public String getProcessingDate() {
		return processingDate;
	}

	/**
	 * Sets the processing date.
	 *
	 * @param processingDate the new processing date
	 */
	public void setProcessingDate(String processingDate) {
		this.processingDate = processingDate;
	}

	/**
	 * Gets the reference.
	 *
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * Sets the reference.
	 *
	 * @param reference the new reference
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * Gets the scheme payment sub type.
	 *
	 * @return the scheme payment sub type
	 */
	public String getSchemePaymentSubType() {
		return schemePaymentSubType;
	}

	/**
	 * Sets the scheme payment sub type.
	 *
	 * @param schemePaymentSubType the new scheme payment sub type
	 */
	public void setSchemePaymentSubType(String schemePaymentSubType) {
		this.schemePaymentSubType = schemePaymentSubType;
	}

	/**
	 * Gets the scheme payment type.
	 *
	 * @return the scheme payment type
	 */
	public String getSchemePaymentType() {
		return schemePaymentType;
	}

	/**
	 * Sets the scheme payment type.
	 *
	 * @param schemePaymentType the new scheme payment type
	 */
	public void setSchemePaymentType(String schemePaymentType) {
		this.schemePaymentType = schemePaymentType;
	}

	/**
	 * Gets the sponsor party.
	 *
	 * @return the sponsor party
	 */
	public SponsorParty getSponsorParty() {
		return sponsorParty;
	}

	/**
	 * Sets the sponsor party.
	 *
	 * @param sponsorParty the new sponsor party
	 */
	public void setSponsorParty(SponsorParty sponsorParty) {
		this.sponsorParty = sponsorParty;
	}
	
	/**
	 * Gets the payment.
	 *
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * Sets the payment.
	 *
	 * @param payment the new payment
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("amount", amount).append("beneficiaryParty", beneficiaryParty)
				.append("chargesInformation", chargesInformation).append("currency", currency)
				.append("debtorParty", debtorParty).append("endToEndReference", endToEndReference).append("fx", fx)
				.append("numericReference", numericReference).append("paymentId", paymentId)
				.append("paymentPurpose", paymentPurpose).append("paymentScheme", paymentScheme)
				.append("paymentType", paymentType).append("processingDate", processingDate)
				.append("reference", reference).append("schemePaymentSubType", schemePaymentSubType)
				.append("schemePaymentType", schemePaymentType).append("sponsorParty", sponsorParty).toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(chargesInformation).append(paymentPurpose).append(endToEndReference)
				.append(debtorParty).append(schemePaymentType).append(schemePaymentSubType).append(paymentType)
				.append(paymentId).append(fx).append(sponsorParty).append(beneficiaryParty).append(numericReference)
				.append(reference).append(currency).append(amount).append(paymentScheme).append(processingDate)
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
		if ((other instanceof Attributes) == false) {
			return false;
		}
		Attributes rhs = ((Attributes) other);
		return new EqualsBuilder().append(chargesInformation, rhs.chargesInformation)
				.append(paymentPurpose, rhs.paymentPurpose).append(endToEndReference, rhs.endToEndReference)
				.append(debtorParty, rhs.debtorParty).append(schemePaymentType, rhs.schemePaymentType)
				.append(schemePaymentSubType, rhs.schemePaymentSubType).append(paymentType, rhs.paymentType)
				.append(paymentId, rhs.paymentId).append(fx, rhs.fx).append(sponsorParty, rhs.sponsorParty)
				.append(beneficiaryParty, rhs.beneficiaryParty).append(numericReference, rhs.numericReference)
				.append(reference, rhs.reference).append(currency, rhs.currency).append(amount, rhs.amount)
				.append(paymentScheme, rhs.paymentScheme).append(processingDate, rhs.processingDate).isEquals();
	}

}