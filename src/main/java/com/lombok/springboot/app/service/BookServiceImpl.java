package com.lombok.springboot.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lombok.springboot.app.domain.Book;
import com.lombok.springboot.app.dto.BookDTO;
import com.lombok.springboot.app.repository.BookRepository;
import com.lombok.springboot.app.utils.BookMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRespository;

	@Override
	public List<BookDTO> getAllResource() {
		List<Book> books = bookRespository.findAll();
		return BookMapper.bookToBookDtoMapperList(books);
	}

	@Override
	@Transactional
	public BookDTO createResource(BookDTO bookDTO) {
		Book book = bookRespository.save(BookMapper.bookDtoToBookMapper(bookDTO));
		return BookMapper.bookToBookDtoMapper(book);

	}

	@Override
	@Transactional
	public BookDTO udpateResource(BookDTO bookDTO) {
		return createResource(bookDTO);
	}

	@Override
	@Transactional
	public void deleteResource(BookDTO bookDTO) {
		bookRespository.delete(BookMapper.bookDtoToBookMapper(bookDTO));
	}
}
