package biz.cosee.talks.cleanarchitecture.tools.mapstruct;

import biz.cosee.talks.cleanarchitecture.domain.book.Isbn13;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommonMapper {

    default String isbn13ToString(Isbn13 isbn13) {
        return isbn13.getValue();
    }
}
