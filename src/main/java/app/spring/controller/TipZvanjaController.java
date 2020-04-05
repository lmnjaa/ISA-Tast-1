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

import app.spring.dto.TipZvanjaDTO;
import app.spring.model.TipZvanja;
import app.spring.model.Zvanje;
import app.spring.service.TipZvanjaService;
import app.spring.service.ZvanjeService;


@Controller
@RequestMapping(path = "/api/tipovi_zvanja")
public class TipZvanjaController
{
    @Autowired
    TipZvanjaService tipZvanjaService;

    @Autowired
    ZvanjeService zvanjeService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<TipZvanjaDTO>> getAllTipZvanja()
    {
        List<TipZvanjaDTO> tipoviZvanja = new ArrayList<>();

        for(TipZvanja tipZvanja: tipZvanjaService.findAll()){
            tipoviZvanja.add(new TipZvanjaDTO(tipZvanja));
        }

        return new ResponseEntity<>(tipoviZvanja, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TipZvanjaDTO> getOneTipZvanja(@PathVariable("id") Long id){
        TipZvanja tipZvanja= tipZvanjaService.findById(id);
        if(tipZvanja == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        TipZvanjaDTO tipZvanjaDTO = new TipZvanjaDTO(tipZvanja);
        return new ResponseEntity<TipZvanjaDTO>(tipZvanjaDTO, HttpStatus.OK);
    }

//    Cuvanje novog rekorda

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<TipZvanjaDTO> store(@RequestBody TipZvanjaDTO noviTipZvanja){
        Zvanje zvanje = zvanjeService.findById(noviTipZvanja.getZvanjeId());
        if(zvanje == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TipZvanja tipZvanja = new TipZvanja(noviTipZvanja.getNaziv(), zvanje);
        tipZvanjaService.save(tipZvanja);
        return new ResponseEntity<TipZvanjaDTO>(new TipZvanjaDTO(tipZvanja), HttpStatus.OK);

    }


    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TipZvanjaDTO> update(@PathVariable("id") Long id, @RequestBody TipZvanja dobijeniTipZvanja){
        TipZvanja tipZvanja = tipZvanjaService.findById(id);
        if(tipZvanja == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tipZvanja.setNaziv(dobijeniTipZvanja.getNaziv());
        tipZvanjaService.save(tipZvanja);
        TipZvanjaDTO tipZvanjaDTO = new TipZvanjaDTO(tipZvanja);
        return new ResponseEntity<TipZvanjaDTO>(tipZvanjaDTO, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TipZvanjaDTO> delete(@PathVariable("id") Long id){
        TipZvanja tipZvanja = tipZvanjaService.findById(id);
        if(tipZvanja == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tipZvanjaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
