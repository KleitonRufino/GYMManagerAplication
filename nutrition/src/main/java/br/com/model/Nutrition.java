package br.com.model;

import java.util.Date;

public class Nutrition {
	private Long id;
	private String title;
	private String description;
	private Date dtCreation;

	public Nutrition(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDtCreation() {
		return dtCreation;
	}

	public void setDtCreation(Date dtCreation) {
		this.dtCreation = dtCreation;
	}

}
