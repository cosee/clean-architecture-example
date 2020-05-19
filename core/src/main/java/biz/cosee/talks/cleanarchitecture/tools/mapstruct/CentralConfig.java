package biz.cosee.talks.cleanarchitecture.tools.mapstruct;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring",
        uses = CommonMapper.class,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface CentralConfig {
}
