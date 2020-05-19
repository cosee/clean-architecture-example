package biz.cosee.talks.cleanarchitecture.usecase.managelibrary;

import biz.cosee.talks.cleanarchitecture.domain.book.Book;
import biz.cosee.talks.cleanarchitecture.domain.book.Isbn13;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImportBookServiceTest {

    public static final String ISBN = "1234567890ABC";
    @Mock
    private Books books;

    @Mock
    private ExternalBooksApi externalBooksApi;

    @InjectMocks
    private ImportBookService importBookService;

    @Test
    @DisplayName("importByIsbn calls the correct methods")
    void importByIsbn() {
        Book book = Book.builder()
                .isbn13(new Isbn13(ISBN))
                .name("Test Book")
                .coverUrl("https://example.com/test-book.png")
                .build();

        when(externalBooksApi.findByIsbn(ISBN)).thenReturn(book);

        importBookService.importByIsbn(ISBN);

        verify(externalBooksApi).findByIsbn(ISBN);
        verify(books).saveBook(book);
    }
}
