package guru.springframework.msscbeerservice.web.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws JsonProcessingException {
        String json = "{\"id\":\"8013c2ff-4ddb-4a1d-a72e-53bdae324fa2\",\"version\":null,\"createdDate\":\"2024-07-09T10:45:06+0300\",\"lastModifiedDate\":\"2024-07-09T10:45:06+0300\",\"beerName\":\"BeerName\",\"beerStyle\":\"ALE\",\"upc\":123123123,\"price\":\"12.99\",\"quantityOnHand\":null,\"myLocalDate\":\"20240709\"}";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}