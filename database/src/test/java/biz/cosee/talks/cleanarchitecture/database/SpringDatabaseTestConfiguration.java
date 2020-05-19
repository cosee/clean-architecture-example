package biz.cosee.talks.cleanarchitecture.database;

import biz.cosee.talks.cleanarchitecture.tools.mapstruct.CommonMapper;
import biz.cosee.talks.cleanarchitecture.tools.mapstruct.CommonMapperImpl;
import biz.cosee.talks.cleanarchitecture.usecase.managelibrary.ExternalBooksApi;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * This configuration is intentianally not marked as "@Configuration",
 * because it must not be loaded by the integration-tests in the
 * "main"-package.
 */
@ComponentScan("biz.cosee.talks.cleanarchitecture.database")
@EnableAutoConfiguration
public class SpringDatabaseTestConfiguration {

    @Bean
    public CommonMapper getCommonMapper() {
        return new CommonMapperImpl();
    }

    @MockBean
    private ExternalBooksApi externalBooksApi;

}
