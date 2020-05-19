package biz.cosee.talks.cleanarchitecture.database.gatewayimpl.books;

import biz.cosee.talks.cleanarchitecture.database.entity.book.BookEntity;
import biz.cosee.talks.cleanarchitecture.domain.book.Book;
import biz.cosee.talks.cleanarchitecture.tools.mapstruct.CentralConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = CentralConfig.class)
public interface BookEntityMapper {

    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget BookEntity bookEntity, Book book);

    @Mapping(target = "id", ignore = true)
    BookEntity toEntity(Book book);
}
