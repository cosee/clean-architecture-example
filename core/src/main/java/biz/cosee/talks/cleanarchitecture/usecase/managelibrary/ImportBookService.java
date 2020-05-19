package biz.cosee.talks.cleanarchitecture.usecase.managelibrary;

import biz.cosee.talks.cleanarchitecture.domain.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ImportBookService {


    private final Books books;
    private final ExternalBooksApi externalBooksApi;

    public void importByIsbn(String isbn) {
        Book book = externalBooksApi.findByIsbn(isbn);
        books.saveBook(book);
    }

    // For demonstrating transactions in "core"
    @Transactional
    public void importByIsbnAndWithinTransactionRun(String isbn, Runnable afterSave) {
        Book book = externalBooksApi.findByIsbn(isbn);
        books.saveBook(book);
        afterSave.run();
    }
}
