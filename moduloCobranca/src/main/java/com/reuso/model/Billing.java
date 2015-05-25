package com.reuso.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Billing {

	private Long id;
	private String nameClient;
	private BigDecimal payment;
	private LocalDate expired;

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public LocalDate getExpired() {
		return expired;
	}

	public void setExpired(LocalDate expired) {
		this.expired = expired;
	}

	public Long getId() {
		return id;
	}

}
