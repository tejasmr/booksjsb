package com.tezzio.demo.Book;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private @NonNull String isbn;
	private @NonNull String name;
	private @NonNull String author;
}
