package guru.springframework.msscbeerservice.web.mappers;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,injectionStrategy = InjectionStrategy.CONSTRUCTOR,uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    @Mapping(target = "myLocalDate",ignore = true)
    @Mapping(target = "quantityOnHand",ignore = true)
    BeerDto beerToBeerDto(Beer beer);

    @Mapping(target = "myLocalDate",ignore = true)
    @Mapping(target = "quantityOnHand",ignore = true)
    BeerDto beerToBeerDtoWithInventory(Beer beer);

    @Mapping(target = "minOnHand",ignore = true)
    @Mapping(target = "quantityToBrew",ignore = true)
    Beer beerDtoToBeer(BeerDto dto);

}
