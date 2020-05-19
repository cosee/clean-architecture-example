package biz.cosee.talks.cleanarchitecture.domain.book;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private final Isbn13 isbn13;
    private final String name;
    private final String coverUrl;
}
