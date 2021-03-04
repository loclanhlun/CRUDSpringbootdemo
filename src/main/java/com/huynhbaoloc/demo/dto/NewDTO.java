package com.huynhbaoloc.demo.dto;

import io.swagger.annotations.ApiModelProperty;

public class NewDTO extends AbstractDTO<NewDTO>{
	
	@ApiModelProperty(notes = "This is title of the news")
	private String title;

	@ApiModelProperty(notes = "The thumbnail")
	private String thumbnail;

	@ApiModelProperty(notes = "The content")
	private String content;

	@ApiModelProperty(notes = "The shortDescription")
	private String shortDescription;

	@ApiModelProperty(notes = "The categoryCode")
	private String categoryCode;
	
	

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

}
