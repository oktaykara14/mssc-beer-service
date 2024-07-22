package guru.springframework.msscbeerservice.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -8173722000613225700L;

//    @JsonProperty("beerId")
    @Null
    @Schema(
            description = "Id of Beer",
            name = "id",
            type = "UUID",
            example = "507ac34e-69c9-42e8-91b9-13d113299312"
    )
    private UUID id;

    @Null
    @Schema(
            description = "Version Number",
            name = "version",
            type = "Long",
            example = "1.0"
    )
    private Integer version;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ",shape = JsonFormat.Shape.STRING)
    @Null
    @Schema(
            description = "Date Created",
            name = "createdDate",
            type = "Timestamp",
            example = "2024-07-08T13:55:22.305Z"
    )
    private OffsetDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ",shape = JsonFormat.Shape.STRING)
    @Null
    @Schema(
            description = "Date Updated",
            name = "lastModifiedDate",
            type = "Timestamp",
            example = "2024-07-08T13:55:22.305Z"
    )
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    @Size(min = 3, max = 100)
    @Schema(
            description = "Beer Name",
            name = "beerName",
            type = "String",
            example = "Beer1"
    )
    private String beerName;

    @NotNull
    @Schema(
            description = "Beer Style",
            name = "beerStyle",
            type = "String",
            example = "LAGER"
    )
    private BeerStyleEnum beerStyle;

    @NotNull
    @Schema(
            description = "UPC of Beer",
            name = "upc",
            type = "String",
            example = "1.0"
    )
    private String upc;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Positive
    @NotNull
    @Schema(
            description = "Price",
            name = "price",
            type = "BigDecimal",
            example = "1234.56"
    )
    private BigDecimal price;

    @Positive
    @Schema(
            description = "Quantity On Hand",
            name = "quantityOnHand",
            type = "Integer",
            example = "10"
    )
    private Integer quantityOnHand;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate myLocalDate;
}
