package biz.cosee.talks.cleanarchitecture.database.entity.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    Optional<BookEntity> findByIsbn13(String isbn13);

}
