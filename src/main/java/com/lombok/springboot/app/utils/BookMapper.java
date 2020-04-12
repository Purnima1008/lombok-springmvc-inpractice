/**
 * 
 */
package com.lombok.springboot.app.utils;

import java.util.ArrayList;
import java.util.List;

import com.lombok.springboot.app.domain.Book;
import com.lombok.springboot.app.dto.BookDTO;

/**
 *
 */

public class BookMapper {
	
	public static Book bookDtoToBookMapper(BookDTO bookDTO) {
			return new Book(bookDTO.getId(), 
					bookDTO.getName(),
					bookDTO.getAuthor(),
					bookDTO.getPrice(),
					bookDTO.getQuantity()
					);
		}
	
	
	public static BookDTO bookToBookDtoMapper(Book book) {
		return new BookDTO(book.getId(), 
				book.getName(),
				book.getAuthor(),
				book.getPrice(),
				book.getQuantity()
				);
	}


	public static List<BookDTO> bookToBookDtoMapperList(List<Book> books) {
		List<BookDTO> bookDTOs = new ArrayList<>();
		books.stream().forEach(book -> bookDTOs
				.add(new BookDTO(book.getId(),
						book.getName(), 
						book.getAuthor(), 
						book.getPrice(), 
						book.getQuantity()
						)));
		return bookDTOs;
	}
}
