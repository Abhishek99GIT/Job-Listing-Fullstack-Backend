package com.example.joblisting.models;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "jobpost")
public class Post { 
	
	public Post() {
	}
	@Override
	public String toString() {
		return "Post [desc=" + desc + ", exp=" + exp + ", profile=" + profile + ", techs=" + techs + "]";
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public List<String> getTechs() {
		return techs;
	}
	public void setTechs(List<String> techs) {
		this.techs = techs;
	}
	
	@Field("desc")
	private String desc;
	
	 @Field("exp")
	private int exp;
	 
	 @Field("profile")
	private String profile;
	 
	 @Field("techs")
	private List<String> techs;
	
}

	
	

