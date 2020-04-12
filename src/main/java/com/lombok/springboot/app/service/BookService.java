package com.lombok.springboot.app.service;

import java.util.List;

import com.lombok.springboot.app.dto.BookDTO;

public interface BookService {

	public BookDTO createResource(BookDTO book);

	public List<BookDTO> getAllResource();

	public BookDTO udpateResource(BookDTO book);

	public void deleteResource(BookDTO book);
}
