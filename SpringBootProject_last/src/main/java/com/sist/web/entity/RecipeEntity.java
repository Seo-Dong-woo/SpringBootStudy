package com.sist.web.entity;
/*
 *  NO int 
	TITLE text 
	POSTER text 
	CHEF text 
	LINK text 
	JJIMCOUNT int 
	HIT int
 */
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "recipe")
@Data
public class RecipeEntity {
	@Id
	private int no;
	private String title, poster, chef, link, jjimcount, hit;
	
}
