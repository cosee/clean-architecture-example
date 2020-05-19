package biz.cosee.talks.cleanarchitecture.usecase.managelibrary;

import biz.cosee.talks.cleanarchitecture.domain.book.Book;

public interface ExternalBooksApi {
    Book findByIsbn(String isbn);
}
