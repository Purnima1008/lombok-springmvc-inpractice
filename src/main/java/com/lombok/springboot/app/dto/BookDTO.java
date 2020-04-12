package com.lombok.springboot.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	private int id;
	private String name;
	private String author;
	private Double price;
	private Integer quantity;

}
