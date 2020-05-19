package biz.cosee.talks.cleanarchitecture;

import biz.cosee.talks.cleanarchitecture.database.entity.book.BookRepository;
import biz.cosee.talks.cleanarchitecture.usecase.managelibrary.ImportBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest(classes = CleanArchitectureApplication.class)
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:cleanup.sql")
class ImportBookServiceTransactionTest {

    @Autowired
    private ImportBookService importBookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void transactionRollbackInCore() {
        assertThatThrownBy(() ->
                importBookService.importByIsbnAndWithinTransactionRun("123", this::throwTestException)
        ).isOfAnyClassIn(RuntimeException.class);

        assertThat(bookRepository.findAll()).isEmpty();
    }

    private void throwTestException() {
        throw new RuntimeException("Test-Exception");
    }


    @Test
    void transactionSuccessInCore() {
        importBookService.importByIsbnAndWithinTransactionRun("123", () -> {
        });
        assertThat(bookRepository.findAll()).hasSize(1);
    }


}
