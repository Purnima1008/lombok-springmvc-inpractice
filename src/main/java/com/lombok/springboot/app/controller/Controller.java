package com.lombok.springboot.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lombok.springboot.app.dto.BookDTO;
import com.lombok.springboot.app.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/book")
@RequiredArgsConstructor
public class Controller {
	
	private final BookService bookService;

	/**
	 * controller mapping to get catalogue
	 * 
	 * @return : {@link List} {@code book}
	 */
	@GetMapping(path = "/catalogue")
	public ResponseEntity<List<BookDTO>> getBookCatalog() {
		List<BookDTO> books = bookService.getAllResource();
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}

	@PostMapping(path = "/save-resource")
	public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO bookDTO) {
		BookDTO savedBook = bookService.createResource(bookDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
	}

	@PutMapping(path = "/update-resource")
	public ResponseEntity<BookDTO> updateBookDetails(@RequestBody BookDTO bookDTO) {
		BookDTO updatedBook = bookService.udpateResource(bookDTO);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedBook);
	}

	@DeleteMapping(path = "/delete-resource")
	public ResponseEntity<String> deleteBook(@RequestBody BookDTO bookDTO) {
		bookService.deleteResource(bookDTO);
		return ResponseEntity.status(HttpStatus.OK).body("book deleted!!");
	}

}
