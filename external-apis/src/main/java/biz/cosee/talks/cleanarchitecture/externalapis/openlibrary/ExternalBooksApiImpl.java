package biz.cosee.talks.cleanarchitecture.externalapis.openlibrary;

import biz.cosee.talks.cleanarchitecture.domain.book.Book;
import biz.cosee.talks.cleanarchitecture.domain.book.Isbn13;
import biz.cosee.talks.cleanarchitecture.usecase.managelibrary.ExternalBooksApi;
import org.springframework.stereotype.Service;

@Service
public class ExternalBooksApiImpl implements ExternalBooksApi {
    @Override
    public Book findByIsbn(String isbn) {
        return Book.builder()
                .name("fake book")
                .coverUrl("abc")
                .isbn13(new Isbn13("test"))
                .build();
    }
}
