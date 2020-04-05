package app.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.spring.dto.NaucnaOblastDTO;
import app.spring.model.NaucnaOblast;
import app.spring.model.Zvanje;
import app.spring.service.NaucnaOblastService;
import app.spring.service.ZvanjeService;


@Controller
@RequestMapping(path = "/api/naucne_oblasti")
public class NaucnaOblastController
{

    @Autowired
    NaucnaOblastService naucnaOblastService;

    @Autowired
    ZvanjeService zvanjeService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<NaucnaOblastDTO>> getAllNaucnaOblast()
    {
        List<NaucnaOblastDTO> naucneOblasti = new ArrayList<>();
        for(NaucnaOblast naucnaOblast: naucnaOblastService.findAll()){
            naucneOblasti.add(new NaucnaOblastDTO(naucnaOblast));
        }

        return new ResponseEntity<>(naucneOblasti, HttpStatus.OK);
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<NaucnaOblastDTO> getOneNaucnaOblast(@PathVariable("id") Long id){
        NaucnaOblast naucnaOblast = naucnaOblastService.findById(id);
        if(naucnaOblast == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        NaucnaOblastDTO naucnaOblastDTO = new NaucnaOblastDTO(naucnaOblast);
        return new ResponseEntity<NaucnaOblastDTO>(naucnaOblastDTO, HttpStatus.OK);

    }
//    Cuvanje novog rekorda naucne oblasti u db
    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<NaucnaOblastDTO> store(@RequestBody NaucnaOblastDTO novaNaucnaOblast){
        Zvanje zvanje = zvanjeService.findById(novaNaucnaOblast.getZvanjeId());

        if(zvanje  == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        NaucnaOblast naucnaOblast = new NaucnaOblast(novaNaucnaOblast.getNaziv(), zvanje);
        naucnaOblastService.save(naucnaOblast);

        return new ResponseEntity<NaucnaOblastDTO>(new NaucnaOblastDTO(naucnaOblast), HttpStatus.OK);
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<NaucnaOblastDTO> update(@PathVariable("id") Long id, @RequestBody NaucnaOblast dobijenaNaucnaOblast){
        NaucnaOblast naucnaOblast = naucnaOblastService.findById(id);
        if(naucnaOblast == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        naucnaOblast.setNaziv(dobijenaNaucnaOblast.getNaziv());
        naucnaOblastService.save(naucnaOblast);
        NaucnaOblastDTO naucnaOblastDTO = new NaucnaOblastDTO(naucnaOblast);
        return new ResponseEntity<NaucnaOblastDTO>(naucnaOblastDTO, HttpStatus.OK);
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<NaucnaOblastDTO> delete(@PathVariable("id") Long id){
        NaucnaOblast naucnaOblast = naucnaOblastService.findById(id);
        if(naucnaOblast == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        naucnaOblastService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}