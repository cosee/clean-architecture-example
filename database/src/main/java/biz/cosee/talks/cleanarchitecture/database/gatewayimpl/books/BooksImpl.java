package biz.cosee.talks.cleanarchitecture.database.gatewayimpl.books;

import biz.cosee.talks.cleanarchitecture.database.entity.book.BookEntity;
import biz.cosee.talks.cleanarchitecture.database.entity.book.BookRepository;
import biz.cosee.talks.cleanarchitecture.domain.book.Book;
import biz.cosee.talks.cleanarchitecture.usecase.managelibrary.Books;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksImpl implements Books {

    private final BookEntityMapper bookEntityMapper;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public void saveBook(Book book) {
        String isbn13AsString = book.getIsbn13().getValue();
        Optional<BookEntity> optionalEntity = bookRepository.findByIsbn13(isbn13AsString);
        if (optionalEntity.isPresent()) {
            bookEntityMapper.updateEntity(optionalEntity.get(), book);
        } else {
            BookEntity bookEntity = bookEntityMapper.toEntity(book);
            bookRepository.save(bookEntity);
        }
    }
}
