package biz.cosee.talks.cleanarchitecture.database.gatewayimpl.books;

import biz.cosee.talks.cleanarchitecture.database.SpringDatabaseTestConfiguration;
import biz.cosee.talks.cleanarchitecture.database.entity.book.BookEntity;
import biz.cosee.talks.cleanarchitecture.database.entity.book.BookRepository;
import biz.cosee.talks.cleanarchitecture.domain.book.Book;
import biz.cosee.talks.cleanarchitecture.domain.book.Isbn13;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:cleanup.sql")
@ContextConfiguration(classes = SpringDatabaseTestConfiguration.class)
class BooksImplTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BooksImpl books;

    @Test
    void clearingDataWorks() {
        List<BookEntity> allEntities = bookRepository.findAll();
        assertThat(allEntities).isEmpty();
    }

    @Test
    void saveBook() {
        books.saveBook(Book.builder()
                .isbn13(new Isbn13("9783411040148"))
                .name("Duden")
                .coverUrl("https://covers.openlibrary.org/b/id/6868661-M.jpg")
                .build()
        );


        List<BookEntity> allEntities = bookRepository.findAll();
        assertThat(allEntities).hasSize(1);
        assertThat(allEntities.get(0).getIsbn13()).isEqualTo("9783411040148");
        assertThat(allEntities.get(0).getName()).isEqualTo("Duden");
        assertThat(allEntities.get(0).getCoverUrl()).isEqualTo("https://covers.openlibrary.org/b/id/6868661-M.jpg");


    }
}
