package guru.springframework.msscbeerservice.web.controller;

import guru.springframework.msscbeerservice.services.BeerService;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    @Operation(summary = "Beer List",description = "This method lists the beers")
    public ResponseEntity<BeerDto> getBeerById(@Parameter(description = "Id of Beer",required = true)
                                                   @PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create a new beer",description = "This method creates a new beer")
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto){

        return new ResponseEntity<>(beerService.saveNewBeer(beerDto),HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    @Operation(summary = "Update the beer",description = "This method updates the beer infos")
    public ResponseEntity updateBeerById(@Parameter(description = "Id of Beer",required = true)
                                             @PathVariable("beerId") UUID beerId,@RequestBody @Validated BeerDto beerDto){

        return new ResponseEntity<>(beerService.updateBeer(beerId,beerDto),HttpStatus.NO_CONTENT);
    }

}
