package com.example.demo.controller;


import com.example.demo.model.Kommune;
import com.example.demo.model.Sogne;
import com.example.demo.repository.KommuneRepository;
import com.example.demo.repository.SogneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final SogneRepository sogneRepository;
    private final KommuneRepository kommuneRepository;



    public RestController(SogneRepository sogneRepository, KommuneRepository kommuneRepository) {
        this.sogneRepository = sogneRepository;
        this.kommuneRepository = kommuneRepository;
    }

    @PostMapping(value = "/opretSogn", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Sogne opretSogn(@RequestBody Sogne sogne){
        Kommune kommune = kommuneRepository.findByKommuneNavn(sogne.getKommune());

        if (kommune != null){
            int gammelSmitte = kommune.getSmittede();
            int nySmitte = gammelSmitte+sogne.getSmittetryk();
            kommune.setSmittede(nySmitte);
            kommuneRepository.save(kommune);
        }
        return sogneRepository.save(sogne);
    }

    @GetMapping("/alleSogne")
    public List<Sogne> findAlleSogne(){
        List<Sogne> sogne = sogneRepository.findAll();
        return sogne;
    }

    @GetMapping("/alleKommuner")
    public List<Kommune> findAlleKommuner(){
        List<Kommune> kommune = kommuneRepository.findAll();
        return kommune;
    }

    @GetMapping("/enkeltSogn/{id}")
    public ResponseEntity<Sogne> enkelSogn(@PathVariable Long id){
        Optional<Sogne> sogne = sogneRepository.findById(id);
        if (sogne.isPresent()){
            Sogne sogn = sogne.get();
            return new ResponseEntity<>(sogn, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "/opdaterSogn", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Sogne opdaterSogn(@RequestBody Sogne sogne){
        return sogneRepository.save(sogne);
    }

    @RequestMapping(value = "/sletSogn/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String sletSogn(@PathVariable Long id){

        Optional<Sogne> sogneOpt =sogneRepository.findById(id);
        if (sogneOpt.isPresent()){
            Sogne sogne = sogneOpt.get();
            Kommune kommune = kommuneRepository.findByKommuneNavn(sogne.getKommune());
            int gammelSmitte = kommune.getSmittede();
            int nySmitte = gammelSmitte-sogne.getSmittetryk();
            kommune.setSmittede(nySmitte);
            kommuneRepository.save(kommune);
        }
        sogneRepository.deleteById(id);
        return "Sogn er Slettet";

    }

}
