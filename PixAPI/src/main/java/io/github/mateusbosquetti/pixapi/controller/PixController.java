package io.github.mateusbosquetti.pixapi.controller;


import io.github.mateusbosquetti.pixapi.model.dto.PixRequestDTO;
import io.github.mateusbosquetti.pixapi.model.entity.Pix;
import io.github.mateusbosquetti.pixapi.service.PixService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("pix")
@RestController
@AllArgsConstructor
public class PixController {

    private final PixService service;

    @PostMapping
    public ResponseEntity<Pix> createPix(@RequestBody PixRequestDTO pixRequestDTO) {
        return new ResponseEntity<>(this.service.createPix(pixRequestDTO), HttpStatus.CREATED);
    }

}
